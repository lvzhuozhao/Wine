package com.wuxiaolong.androidmvpsample.bean;

import java.util.List;

/**
 * Created by LZZ on 2017/8/28.
 */

public class Find {

    /**
     * jsonInfo : {"code":"0","data":[{"checkInDate":"2017-08-28 00:00:00","checkOutDate":"2017-08-29 00:00:00","count":"","department":"","guestName":"Wang","guestPhone":"18501176671","guestRemarks":"123","guestSource":"散客","market":"新建","orderNumber":"YX1503634484399","orderStatus":"已预定","orderSum":"","reserveDate":"2017-08-25 12:14:44","reserveUser":"","roomType":"豪华标间","sum":"123.0"},{"checkInDate":"2017-08-28 00:00:00","checkOutDate":"2017-08-29 00:00:00","count":"","department":"","guestName":"Wang","guestPhone":"18501176671","guestRemarks":"123","guestSource":"散客","market":"新建","orderNumber":"YX1503634484233","orderStatus":"已预定","orderSum":"","reserveDate":"2017-08-25 12:14:44","reserveUser":"","roomType":"普通标间","sum":"123.0"}],"msg":"成功"}
     */

    private JsonInfoBean jsonInfo;

    public JsonInfoBean getJsonInfo() {
        return jsonInfo;
    }

    public void setJsonInfo(JsonInfoBean jsonInfo) {
        this.jsonInfo = jsonInfo;
    }

    public static class JsonInfoBean {
        /**
         * code : 0
         * data : [{"checkInDate":"2017-08-28 00:00:00","checkOutDate":"2017-08-29 00:00:00","count":"","department":"","guestName":"Wang","guestPhone":"18501176671","guestRemarks":"123","guestSource":"散客","market":"新建","orderNumber":"YX1503634484399","orderStatus":"已预定","orderSum":"","reserveDate":"2017-08-25 12:14:44","reserveUser":"","roomType":"豪华标间","sum":"123.0"},{"checkInDate":"2017-08-28 00:00:00","checkOutDate":"2017-08-29 00:00:00","count":"","department":"","guestName":"Wang","guestPhone":"18501176671","guestRemarks":"123","guestSource":"散客","market":"新建","orderNumber":"YX1503634484233","orderStatus":"已预定","orderSum":"","reserveDate":"2017-08-25 12:14:44","reserveUser":"","roomType":"普通标间","sum":"123.0"}]
         * msg : 成功
         */

        private String code;
        private String msg;
        private List<DataBean> data;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * checkInDate : 2017-08-28 00:00:00
             * checkOutDate : 2017-08-29 00:00:00
             * count :
             * department :
             * guestName : Wang
             * guestPhone : 18501176671
             * guestRemarks : 123
             * guestSource : 散客
             * market : 新建
             * orderNumber : YX1503634484399
             * orderStatus : 已预定
             * orderSum :
             * reserveDate : 2017-08-25 12:14:44
             * reserveUser :
             * roomType : 豪华标间
             * sum : 123.0
             */

            private String checkInDate;
            private String checkOutDate;
            private String count;
            private String department;
            private String guestName;
            private String guestPhone;
            private String guestRemarks;
            private String guestSource;
            private String market;
            private String orderNumber;
            private String orderStatus;
            private String orderSum;
            private String reserveDate;
            private String reserveUser;
            private String roomType;
            private String sum;

            public String getCheckInDate() {
                return checkInDate;
            }

            public void setCheckInDate(String checkInDate) {
                this.checkInDate = checkInDate;
            }

            public String getCheckOutDate() {
                return checkOutDate;
            }

            public void setCheckOutDate(String checkOutDate) {
                this.checkOutDate = checkOutDate;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getGuestName() {
                return guestName;
            }

            public void setGuestName(String guestName) {
                this.guestName = guestName;
            }

            public String getGuestPhone() {
                return guestPhone;
            }

            public void setGuestPhone(String guestPhone) {
                this.guestPhone = guestPhone;
            }

            public String getGuestRemarks() {
                return guestRemarks;
            }

            public void setGuestRemarks(String guestRemarks) {
                this.guestRemarks = guestRemarks;
            }

            public String getGuestSource() {
                return guestSource;
            }

            public void setGuestSource(String guestSource) {
                this.guestSource = guestSource;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getOrderSum() {
                return orderSum;
            }

            public void setOrderSum(String orderSum) {
                this.orderSum = orderSum;
            }

            public String getReserveDate() {
                return reserveDate;
            }

            public void setReserveDate(String reserveDate) {
                this.reserveDate = reserveDate;
            }

            public String getReserveUser() {
                return reserveUser;
            }

            public void setReserveUser(String reserveUser) {
                this.reserveUser = reserveUser;
            }

            public String getRoomType() {
                return roomType;
            }

            public void setRoomType(String roomType) {
                this.roomType = roomType;
            }

            public String getSum() {
                return sum;
            }

            public void setSum(String sum) {
                this.sum = sum;
            }
        }
    }
}
