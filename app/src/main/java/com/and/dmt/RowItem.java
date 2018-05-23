package com.and.dmt;

/**
 * Created by user on 11/22/2017.
 */

public class RowItem {
    private boolean delete;
    private int arrow;
    private String title;
    private String hint;
    private String value;

    public RowItem(boolean delete, int arrow, String title, String hint, String value) {

        this.delete = delete;
        this.arrow = arrow;
        this.title = title;
        this.hint = hint;
        this.value = value;
    }
    public boolean getDeleteStatus(){
        return delete;
    }
    public void setDeleteStatus(boolean delete){
        this.delete = delete;
    }
    public int getImgID() {
        return arrow;
    }
    public void setImgID(int arrow) {
        this.arrow = arrow;
    }
    public String getHint() {
        return hint;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return title + "\n" + hint;
    }
}