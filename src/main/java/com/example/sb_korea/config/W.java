package com.example.sb_korea.config;

import java.util.List;

/**
 * @author hao.wong
 * @date 2021/12/27
 */
public class W {
    private List<RightsCard> rightsCard;

    public List<RightsCard> getRightsCard() {

        return rightsCard;
    }

    public void setRightsCard(List<RightsCard> rightsCard) {
        this.rightsCard = rightsCard;
    }

    /**
     * Copyright 2021 json.cn
     */

    /**
     * Auto-generated: 2021-12-27 15:35:42
     *
     * @author json.cn (i@json.cn)
     * @website http://www.json.cn/java2pojo/
     */
    public static class Cards {

        private String id;
        private String cardId;
        private String icon;
        private String name;
        private int validPeriod;
        private int price;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
        public String getCardId() {
            return cardId;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
        public String getIcon() {
            return icon;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setValidPeriod(int validPeriod) {
            this.validPeriod = validPeriod;
        }
        public int getValidPeriod() {
            return validPeriod;
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }

    }


    /**
     * Auto-generated: 2021-12-27 15:35:42
     *
     * @author json.cn (i@json.cn)
     * @website http://www.json.cn/java2pojo/
     */
    public static class Extras {

        private String id;
        private int type;
        private int amount;
        private List<String> extraItems;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
        public int getAmount() {
            return amount;
        }

        public void setExtraItems(List<String> extraItems) {
            this.extraItems = extraItems;
        }
        public List<String> getExtraItems() {
            return extraItems;
        }

    }

    public static class Steps {

        private String id;
        private int condition;
        private int discountType;
        private int reduceAmount;
        private int discount;
        private int price;
        private List<Cards> cards;
        private List<Extras> extras;

        private int amount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }
        public int getCondition() {
            return condition;
        }

        public void setDiscountType(int discountType) {
            this.discountType = discountType;
        }
        public int getDiscountType() {
            return discountType;
        }

        public void setReduceAmount(int reduceAmount) {
            this.reduceAmount = reduceAmount;
        }
        public int getReduceAmount() {
            return reduceAmount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
        public int getDiscount() {
            return discount;
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }

        public void setCards(List<Cards> cards) {
            this.cards = cards;
        }
        public List<Cards> getCards() {
            return cards;
        }

        public void setExtras(List<Extras> extras) {
            this.extras = extras;
        }
        public List<Extras> getExtras() {
            return extras;
        }

    }

    /**
     * Copyright 2021 json.cn
     */

    /**
     * Auto-generated: 2021-12-27 15:35:42
     *
     * @author json.cn (i@json.cn)
     * @website http://www.json.cn/java2pojo/
     */
    public static class RightsCard {

        private String id;
        private String merchantId;
        private String name;
        private int expiredType;
        private String startTime;
        private String endTime;
        private List<String> scopes;
        private List<Steps> steps;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }
        public String getMerchantId() {
            return merchantId;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setExpiredType(int expiredType) {
            this.expiredType = expiredType;
        }
        public int getExpiredType() {
            return expiredType;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
        public String getStartTime() {
            return startTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
        public String getEndTime() {
            return endTime;
        }

        public void setScopes(List<String> scopes) {
            this.scopes = scopes;
        }
        public List<String> getScopes() {
            return scopes;
        }

        public void setSteps(List<Steps> steps) {
            this.steps = steps;
        }
        public List<Steps> getSteps() {
            return steps;
        }

    }

}
