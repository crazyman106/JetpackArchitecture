package com.test.adproject.net;

class Params {
    /* String package_id = "1";
     String wechat = "o94OB1RbYFmzyNDWePJdCwWWBhsw";*/
    String uuid = "FA51A0A1-A023-4B11-8FE8-491F3FC75DBD";
    String electric = "-1.000000";
    String idfa = "62812B2A-694B-4443-8AEE-AD4D2D8C30E8";
    String isp = "44554";
    String bundle_id = "com.app.cheyoufuwu.test";
    String os = "ios";
    String ip = "125.235.133.166";
    String is_escape = "1";
    String network = "4G";
    String os_version = "12.0";
    String mobile_model = "S5imulator";
    String proxySet = "未设置代理";

    public String getParams() {
        return "uuid=" + uuid + "&electric=" + electric + "&idfa=" + idfa + "&isp=" + isp + "&bundle_id="
                + bundle_id + "&os=" + os + "&ip=" + ip + "&is_escape=" + is_escape + "&network=" + network
                + "&os_version=" + os_version + "&mobile_model=" + mobile_model + "&proxySet=" + proxySet /*+ "&package_id=" + package_id + "&wechat=" + wechat*/;
    }
}