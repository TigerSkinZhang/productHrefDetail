package com.android.zjshare.entity;



import java.util.List;

public class CommentInfo   {

        private String totalNum;
        private String goodCommentNum;
        private String middleCommentNum;
        private String badCommentNum;
        private String picCommentNum;

        private List<CommentItemBean> list;

        public List<CommentItemBean> getList() {
            return list;
        }

        public void setList(List<CommentItemBean> list) {
            this.list = list;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(String totalNum) {
            this.totalNum = totalNum;
        }

        public String getGoodCommentNum() {
            return goodCommentNum;
        }

        public void setGoodCommentNum(String goodCommentNum) {
            this.goodCommentNum = goodCommentNum;
        }

        public String getMiddleCommentNum() {
            return middleCommentNum;
        }

        public void setMiddleCommentNum(String middleCommentNum) {
            this.middleCommentNum = middleCommentNum;
        }

        public String getBadCommentNum() {
            return badCommentNum;
        }

        public void setBadCommentNum(String badCommentNum) {
            this.badCommentNum = badCommentNum;
        }

        public String getPicCommentNum() {
            return picCommentNum;
        }

        public void setPicCommentNum(String picCommentNum) {
            this.picCommentNum = picCommentNum;
        }

        public static class CommentItemBean {
            private String id;
            private String goodsId;
            private String userId;
            private String satisfiedPoint;
            private String content;
            private String createUser;
            private String createTime;
            private String isShow;
            private String avatarImage;
            private String userName;

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getSatisfiedPoint() {
                return satisfiedPoint;
            }

            public void setSatisfiedPoint(String satisfiedPoint) {
                this.satisfiedPoint = satisfiedPoint;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
                this.isShow = isShow;
            }

            public String getAvatarImage() {
                return avatarImage;
            }

            public void setAvatarImage(String avatarImage) {
                this.avatarImage = avatarImage;
            }
    }
}
