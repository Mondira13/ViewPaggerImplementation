package com.example.enc.viewpagger;


public enum ModelObject {

    RED(R.string.viewProfile, R.layout.view_profile),
    GREEN(R.string.editProfile, R.layout.edit_profile);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}




