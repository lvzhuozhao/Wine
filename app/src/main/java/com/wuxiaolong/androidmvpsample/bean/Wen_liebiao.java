package com.wuxiaolong.androidmvpsample.bean;

import java.util.List;

/**
 * Created by LZZ on 2017/8/31.
 */

public class Wen_liebiao {

    /**
     * jsonInfo : {"code":"0","data":[{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"--","count":"","department":"温泉部","guestCount":"0","guestName":"呵呵","guestPhone":"136","guestRemarks":"123","guestSource":"散客","market":"南昌","oid":"61","orderNumber":"KF1504146815537","orderStatus":"已预定","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 10:33:35","reserveType":"一般","reserveUser":"spring","roomType":"--","sum":"￥50.0"},{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"--","count":"","department":"温泉部","guestCount":"0","guestName":"呵呵","guestPhone":"123","guestRemarks":"123","guestSource":"散客","market":"南昌","oid":"60","orderNumber":"KF1504146764127","orderStatus":"已预定","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 10:32:44","reserveType":"一般","reserveUser":"spring","roomType":"--","sum":"￥50.0"}],"msg":"成功"}
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
         * data : [{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"--","count":"","department":"温泉部","guestCount":"0","guestName":"呵呵","guestPhone":"136","guestRemarks":"123","guestSource":"散客","market":"南昌","oid":"61","orderNumber":"KF1504146815537","orderStatus":"已预定","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 10:33:35","reserveType":"一般","reserveUser":"spring","roomType":"--","sum":"￥50.0"},{"checkInDate":"2017-08-31 00:00:00","checkOutDate":"--","count":"","department":"温泉部","guestCount":"0","guestName":"呵呵","guestPhone":"123","guestRemarks":"123","guestSource":"散客","market":"南昌","oid":"60","orderNumber":"KF1504146764127","orderStatus":"已预定","orderSum":"","oweMoneyType":"","reserveDate":"2017-08-31 10:32:44","reserveType":"一般","reserveUser":"spring","roomType":"--","sum":"￥50.0"}]
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
             * checkInDate : 2017-08-31 00:00:00
             * checkOutDate : --
             * count :
             * department : 温泉部
             * guestCount : 0
             * guestName : 呵呵
             * guestPhone : 136
             * guestRemarks : 123
             * guestSource : 散客
             * market : 南昌
             * oid : 61
             * orderNumber : KF1504146815537
             * orderStatus : 已预定
             * orderSum :
             * oweMoneyType :
             * reserveDate : 2017-08-31 10:33:35
             * reserveType : 一般
             * reserveUser : spring
             * roomType : --
             * sum : ￥50.0
             */

            private String checkInDate;
            private String checkOutDate;
            private String count;
            private String department;
            private String guestCount;
            private String guestName;
            private String guestPhone;
            private String guestRemarks;
            private String guestSource;
            private String market;
            private String oid;
            private String orderNumber;
            private String orderStatus;
            private String orderSum;
            private String oweMoneyType;
            private String reserveDate;
            private String reserveType;
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

            public String getGuestCount() {
                return guestCount;
            }

            public void setGuestCount(String guestCount) {
                this.guestCount = guestCount;
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

            public String getOid() {
                return oid;
            }

            public void setOid(String oid) {
                this.oid = oid;
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

            public String getOweMoneyType() {
                return oweMoneyType;
            }

            public void setOweMoneyType(String oweMoneyType) {
                this.oweMoneyType = oweMoneyType;
            }

            public String getReserveDate() {
                return reserveDate;
            }

            public void setReserveDate(String reserveDate) {
                this.reserveDate = reserveDate;
            }

            public String getReserveType() {
                return reserveType;
            }

            public void setReserveType(String reserveType) {
                this.reserveType = reserveType;
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
