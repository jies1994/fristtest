package com.jies.test;

import java.util.List;

/**
 * Created by peijie on 18/2/11.
 */
public class SettleStatusChangeMessage {

    private Integer oldStatus;

    private Integer newStatus;

    private String SettleSerialNo;

    //变为新状态的物品详细
    private List<SettleProductDetail> productDetails;
}
