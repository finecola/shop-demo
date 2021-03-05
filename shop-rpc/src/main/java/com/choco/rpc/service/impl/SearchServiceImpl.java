package com.choco.rpc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.choco.common.result.ShopPageInfo;
import com.choco.rpc.service.SearchService;
import com.choco.rpc.vo.GoodsVo;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by choco on 2021/1/5 10:41
 */
@Service(interfaceClass = SearchService.class)
@Component
public class SearchServiceImpl implements SearchService {
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Override
    public ShopPageInfo<GoodsVo> searchGoodsVo(String keyword, int pageNum, int pageSize) {
        ShopPageInfo<GoodsVo> shopPageInfo;
        try {
            //指定索引库
            SearchRequest searchRequest = new SearchRequest("shop");
            //
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //构造分页条件
            sourceBuilder.from((pageNum - 1) * pageSize).size(pageSize);
            //构造高亮builder
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("goodsName").preTags("<span style='color: red;'>").postTags("</span>");
            sourceBuilder.highlighter(highlightBuilder);

            //关键词查询
            sourceBuilder.query(QueryBuilders.multiMatchQuery(keyword, "goodsName"));

            searchRequest.source(sourceBuilder);

            ArrayList<GoodsVo> list = new ArrayList<>();

            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
            Long value = response.getHits().getTotalHits().value;
            //判断是否获取数据成功
            if (0 >value ) {
                return null;
            }

            SearchHit[] hits = response.getHits().getHits();
            for (SearchHit hit : hits) {
                //获取高亮字段
                HighlightField content = hit.getHighlightFields().get("goodsName");
                String newContent = String.valueOf(content.fragments()[0]);

                Integer goodsId = (Integer) hit.getSourceAsMap().get("goodsId");
                String goodsName = (String) hit.getSourceAsMap().get("goodsName");
                String originalImg = (String) hit.getSourceAsMap().get("originalImg");
                BigDecimal marketPrice = new BigDecimal(String.valueOf(hit.getSourceAsMap().get("marketPrice")));
                GoodsVo goodsVo = new GoodsVo(goodsId, goodsName, newContent, marketPrice, originalImg);
                list.add(goodsVo);
                //分页处理
                shopPageInfo=new ShopPageInfo<GoodsVo>(pageNum,pageSize,value.intValue());
                shopPageInfo.setResult(list);
                return shopPageInfo;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
