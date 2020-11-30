package com.android.zjshare.entity;


import java.util.List;

public class ProductDetailBean   {
        private int id;
        private String userId;
        private String catCode;
        private int brandId;
        private String goodsCode;
        private String goodsName;
        private String goodsTitle;
        private int salesVolume;
        private String marketPrice;
        private String costPrice;
        private String defaultImg;
        private List<String> imgs;
        private String goodsPcDesc;
        private int salesNumber;
        private int isOnSale;
        private String isBest;
        private String isHot;
        private String isPromote;
        private String isDelete;
        private String deliveryWay;
        private int status;
        private String typeId;
        private String typeValue;
        private int postagId;
        private int limitNumber;
        private int totalGoodsStock;
        private String goodsType;
        private String createTime;
        private String updateTime;
        private String auditUserName;
        private String auditStatus;
        private String auditOpinion;
        private String auditTime;
        private List<GoodsSpecList> goodsSpecList;
        private List<GoodsAttrList> goodsAttrList;
        private ShopInfo shopDto;

    public ShopInfo getShopDto() {
        return shopDto;
    }

    public void setShopDto(ShopInfo shopDto) {
        this.shopDto = shopDto;
    }

    private String remarks;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
        public GoodsSpecList getSelectSpec(){
            if (goodsSpecList!=null&&goodsSpecList.size()>0){
                for (GoodsSpecList  item:goodsSpecList) {
                    if (item.isSelected())
                        return item;
                }
            }
            return null;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getUserId() {
            return userId;
        }

        public void setCatCode(String catCode) {
            this.catCode = catCode;
        }
        public String getCatCode() {
            return catCode;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }
        public int getBrandId() {
            return brandId;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }
        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }
        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }
        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }
        public int getSalesVolume() {
            return salesVolume;
        }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public void setDefaultImg(String defaultImg) {
            this.defaultImg = defaultImg;
        }
        public String getDefaultImg() {
            return defaultImg;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
        public List<String> getImgs() {
            return imgs;
        }

        public void setGoodsPcDesc(String goodsPcDesc) {
            this.goodsPcDesc = goodsPcDesc;
        }
        public String getGoodsPcDesc() {
            return goodsPcDesc;
        }

        public void setSalesNumber(int salesNumber) {
            this.salesNumber = salesNumber;
        }
        public int getSalesNumber() {
            return salesNumber;
        }

        public void setIsOnSale(int isOnSale) {
            this.isOnSale = isOnSale;
        }
        public int getIsOnSale() {
            return isOnSale;
        }

        public void setIsBest(String isBest) {
            this.isBest = isBest;
        }
        public String getIsBest() {
            return isBest;
        }

        public void setIsHot(String isHot) {
            this.isHot = isHot;
        }
        public String getIsHot() {
            return isHot;
        }

        public void setIsPromote(String isPromote) {
            this.isPromote = isPromote;
        }
        public String getIsPromote() {
            return isPromote;
        }

        public void setIsDelete(String isDelete) {
            this.isDelete = isDelete;
        }
        public String getIsDelete() {
            return isDelete;
        }

        public void setDeliveryWay(String deliveryWay) {
            this.deliveryWay = deliveryWay;
        }
        public String getDeliveryWay() {
            return deliveryWay;
        }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTypeId(String typeId) {
            this.typeId = typeId;
        }
        public String getTypeId() {
            return typeId;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
        public String getTypeValue() {
            return typeValue;
        }

        public void setPostagId(int postagId) {
            this.postagId = postagId;
        }
        public int getPostagId() {
            return postagId;
        }

        public void setLimitNumber(int limitNumber) {
            this.limitNumber = limitNumber;
        }
        public int getLimitNumber() {
            return limitNumber;
        }

        public void setTotalGoodsStock(int totalGoodsStock) {
            this.totalGoodsStock = totalGoodsStock;
        }
        public int getTotalGoodsStock() {
            return totalGoodsStock;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }
        public String getGoodsType() {
            return goodsType;
        }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setAuditUserName(String auditUserName) {
            this.auditUserName = auditUserName;
        }
        public String getAuditUserName() {
            return auditUserName;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }
        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditOpinion(String auditOpinion) {
            this.auditOpinion = auditOpinion;
        }
        public String getAuditOpinion() {
            return auditOpinion;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime;
        }
        public String getAuditTime() {
            return auditTime;
        }

        public void setGoodsSpecList(List<GoodsSpecList> goodsSpecList) {
            this.goodsSpecList = goodsSpecList;
        }
        public List<GoodsSpecList> getGoodsSpecList() {
            return goodsSpecList;
        }

        public void setGoodsAttrList(List<GoodsAttrList> goodsAttrList) {
            this.goodsAttrList = goodsAttrList;
        }
        public List<GoodsAttrList> getGoodsAttrList() {
            return goodsAttrList;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
        public String getRemarks() {
            return remarks;
        }
        public static class ShopInfo{
                private int id;
                private int userId;
                private String shopName;
                private String shopLogo;
                private String shopBannerImg;
                private String shopVideo;
                private String shopTemplate;
                private String isClose;
                private String goodsCount;
                private String companyName;
                private int shopType;
                private String createTime;
                private String createUser;
                private String updateTime;
                private String updateUser;
                private String operationUser;
                private String operationRemarks;
                private String operationTime;
                private String imgUrl1;
                private String imgUrl2;
                private String imgUrl3;
                private String shopNotice;
                private String shopProfile;
                public void setId(int id) {
                    this.id = id;
                }
                public int getId() {
                    return id;
                }

            public String getShopLogo() {
                return shopLogo;
            }

            public void setShopLogo(String shopLogo) {
                this.shopLogo = shopLogo;
            }

            public void setUserId(int userId) {
                    this.userId = userId;
                }
                public int getUserId() {
                    return userId;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }
                public String getShopName() {
                    return shopName;
                }

                public void setShopBannerImg(String shopBannerImg) {
                    this.shopBannerImg = shopBannerImg;
                }
                public String getShopBannerImg() {
                    return shopBannerImg;
                }

                public void setShopVideo(String shopVideo) {
                    this.shopVideo = shopVideo;
                }
                public String getShopVideo() {
                    return shopVideo;
                }

                public void setShopTemplate(String shopTemplate) {
                    this.shopTemplate = shopTemplate;
                }
                public String getShopTemplate() {
                    return shopTemplate;
                }

                public void setIsClose(String isClose) {
                    this.isClose = isClose;
                }
                public String getIsClose() {
                    return isClose;
                }

                public void setGoodsCount(String goodsCount) {
                    this.goodsCount = goodsCount;
                }
                public String getGoodsCount() {
                    return goodsCount;
                }

                public void setCompanyName(String companyName) {
                    this.companyName = companyName;
                }
                public String getCompanyName() {
                    return companyName;
                }

                public void setShopType(int shopType) {
                    this.shopType = shopType;
                }
                public int getShopType() {
                    return shopType;
                }


                public void setCreateUser(String createUser) {
                    this.createUser = createUser;
                }
                public String getCreateUser() {
                    return createUser;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }
                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateUser(String updateUser) {
                    this.updateUser = updateUser;
                }
                public String getUpdateUser() {
                    return updateUser;
                }

                public void setOperationUser(String operationUser) {
                    this.operationUser = operationUser;
                }
                public String getOperationUser() {
                    return operationUser;
                }

                public void setOperationRemarks(String operationRemarks) {
                    this.operationRemarks = operationRemarks;
                }
                public String getOperationRemarks() {
                    return operationRemarks;
                }

                public void setOperationTime(String operationTime) {
                    this.operationTime = operationTime;
                }
                public String getOperationTime() {
                    return operationTime;
                }

                public void setImgUrl1(String imgUrl1) {
                    this.imgUrl1 = imgUrl1;
                }
                public String getImgUrl1() {
                    return imgUrl1;
                }

                public void setImgUrl2(String imgUrl2) {
                    this.imgUrl2 = imgUrl2;
                }
                public String getImgUrl2() {
                    return imgUrl2;
                }

                public void setImgUrl3(String imgUrl3) {
                    this.imgUrl3 = imgUrl3;
                }
                public String getImgUrl3() {
                    return imgUrl3;
                }

                public void setShopNotice(String shopNotice) {
                    this.shopNotice = shopNotice;
                }
                public String getShopNotice() {
                    return shopNotice;
                }

                public void setShopProfile(String shopProfile) {
                    this.shopProfile = shopProfile;
                }
                public String getShopProfile() {
                    return shopProfile;
                }

    }
    public static class GoodsAttrList {

        private int id;
        private int goodsId;
        private int attributeTypeId;
        private int attributeId;
        private String attributeValues;
        private int sort;
        private String attributeName;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }
        public int getGoodsId() {
            return goodsId;
        }

        public void setAttributeTypeId(int attributeTypeId) {
            this.attributeTypeId = attributeTypeId;
        }
        public int getAttributeTypeId() {
            return attributeTypeId;
        }

        public void setAttributeId(int attributeId) {
            this.attributeId = attributeId;
        }
        public int getAttributeId() {
            return attributeId;
        }

        public void setAttributeValues(String attributeValues) {
            this.attributeValues = attributeValues;
        }
        public String getAttributeValues() {
            return attributeValues;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
        public int getSort() {
            return sort;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }
        public String getAttributeName() {
            return attributeName;
        }

    }
    public class GoodsSpecList {
        boolean selected = false;
        boolean enable = true;
        private int id;
        private int goodsId;
        private String specGoodsCode;
        private String specValues;
        private int specGoodsStock;
        private String specSellingPrice;
        private String specType;
        private String userId;
        private String createTime;
        private String updateTime;
        private String isDel;
        private String isOnSale;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }
        public int getGoodsId() {
            return goodsId;
        }

        public void setSpecGoodsCode(String specGoodsCode) {
            this.specGoodsCode = specGoodsCode;
        }
        public String getSpecGoodsCode() {
            return specGoodsCode;
        }

        public void setSpecValues(String specValues) {
            this.specValues = specValues;
        }
        public String getSpecValues() {
            return specValues;
        }

        public void setSpecGoodsStock(int specGoodsStock) {
            this.specGoodsStock = specGoodsStock;
        }
        public int getSpecGoodsStock() {
            return specGoodsStock;
        }

        public void setSpecSellingPrice(String specSellingPrice) {
            this.specSellingPrice = specSellingPrice;
        }
        public String getSpecSellingPrice() {
            return specSellingPrice;
        }

        public void setSpecType(String specType) {
            this.specType = specType;
        }
        public String getSpecType() {
            return specType;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getUserId() {
            return userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setIsDel(String isDel) {
            this.isDel = isDel;
        }
        public String getIsDel() {
            return isDel;
        }

        public void setIsOnSale(String isOnSale) {
            this.isOnSale = isOnSale;
        }
        public String getIsOnSale() {
            return isOnSale;
        }

    }
}
