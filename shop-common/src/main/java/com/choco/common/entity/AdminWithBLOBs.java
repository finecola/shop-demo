/*
*
* AdminWithBLOBs.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-05
*/
package com.choco.common.entity;

import java.io.Serializable;

public class AdminWithBLOBs extends Admin implements Serializable {
    /**
     * 权限
     */
    private String navList;

    /**
     * todolist
     */
    private String todolist;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限
     * @return nav_list 权限
     */
    public String getNavList() {
        return navList;
    }

    /**
     * 权限
     * @param navList 权限
     */
    public void setNavList(String navList) {
        this.navList = navList == null ? null : navList.trim();
    }

    /**
     * todolist
     * @return todolist todolist
     */
    public String getTodolist() {
        return todolist;
    }

    /**
     * todolist
     * @param todolist todolist
     */
    public void setTodolist(String todolist) {
        this.todolist = todolist == null ? null : todolist.trim();
    }

    /**
     *
     * @mbg.generated 2021-01-05
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", navList=").append(navList);
        sb.append(", todolist=").append(todolist);
        sb.append("]");
        return sb.toString();
    }
}
