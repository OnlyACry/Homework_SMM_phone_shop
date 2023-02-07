<%--
  Created by IntelliJ IDEA.
  User: sun1xu
  Date: 2022/11/18
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>手机商场</title>
    <base href="${pageContext.request.contextPath}/resources/">
    <link type="text/css" href="css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="js/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.form.min.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <script type="text/javascript" src="js/payfor.js"></script>

    <script>
        $(function () {
            $("#addItemA").click(function () {
                $("#addItemForm").ajaxSubmit({
                    type: "post",
                    url: $(this).attr("action"),
                    dataType: "json",
                    success: function (data) {
                        if(data.code == 200){
                            alert("增加成功！");
                        }else{
                            alert("增加失败！");
                        }
                    }
                })
            });

            $(".buyji li").click(function(){
                $(this).addClass("byj").siblings("li").removeClass("byj");
                if($("#colorUL .byj").length==0){
                    return;
                }
                if($("#memoryUL .byj").length==0){
                    return;
                }
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/goodsdetail/search",
                    data:{"goodsId":${goods.goodsId}
                        , "colorId": $("#colorUL .byj").attr("colorId")
                        , "memoryId":$("#memoryUL .byj").attr("memoryId")},
                    dataType:"json",
                    success:function (data) {
                        if(data.code == 200){
                            $("#price_item_1").text(data.data.gdPrice.toFixed(2));
                            $("#total_item_1").text("￥"+( ($("#qty_item_1").val() * data.data.gdPrice).toFixed(2) ));
                            $("#goodsNumTd").text(data.data.gdNum);
                            $("#gdId").val(data.data.gdId);
                        }
                    }
                });
            })
        });
    </script>
</head>

<body>
<div class="hrader" id="header">
    <div class="top">
        <a href="login.html" style="color:#C94E13;">请登录</a>
        <a href="reg.html">注册</a>
        <ul class="topNav">
            <li><a href="order.html">我的订单 </a></li>
            <li class="gouwuche"><a href="${pageContext.request.contextPath}/cart/list?userId=${sessionScope.user.userId}">购物车</a><strong style="color:#C94E13;">3</strong></li>
            <li class="shoucangjia"><a href="shoucang.html">收藏夹</a></li>
            <li class="kefus"><a href="#">联系客服</a></li>
            <li><a href="#" class="lan">中文</a></li>
            <li><a href="#" class="lan">English</a></li>
            <div class="clears"></div>
        </ul><!--topNav/-->
    </div><!--top/-->
</div><!--hrader/-->
<div class="mid">
    <h1 class="logo" style="text-align:left;">
        <a href="index.html"><img src="images/logo.png" width="304" height="74" /></a>
    </h1>
    <form action="#" method="get" class="subBox">
        <div class="subBox2">
            <input type="text" class="subText" />
            <input type="image" src="images/sub.jpg" width="95" height="32" class="subImg" />
            <div class="hotci">
                <a href="#">酷派大神</a>
                <a href="#">三星s5</a>
                <a href="#">诺基亚1020</a>
                <a href="#">Iphone 6</a>
                <a href="#">htc one</a>
            </div><!--hotci/-->
        </div><!--subBox2/-->
    </form><!--subBox/-->
    <div class="ding-gou">
        <div class="ding">
            <a href="order.html"><img src="images/dingdan.jpg" width="106" height="32" /></a>
        </div><!--ding/-->
        <div class="gou">
            <a href="car.html"><img src="images/gouwuche.jpg" width="126" height="32" /></a>
        </div><!--gou/-->
        <div class="clears"></div>
    </div><!--ding-gou/-->
</div><!--mid-->
<div class="navBox navBg1">
    <ul class="nav">
        <li><a href="index.html">首页</a></li>
        <li><a href="buy.html">买家</a></li>
        <li><a href="sell.html">卖家</a></li>
        <li><a href="vip.html">会员中心</a></li>
        <li><a href="xuanshang.html">悬赏榜</a></li>
        <li><a href="luntan.html" class="luntan">论坛</a></li>
        <li><a href="help.html">帮助</a></li>
        <div class="clears"></div>
    </ul><!--nav/-->
</div><!--navBox/-->
<div class="bn"><img src="images/dingzhi.jpg" width="972" height="167" /></div>
<div class="buyinfo">
    <div class="buyDtl">
        <div class="buyDtlLeft">
            <div class="buyimgBig">
                <c:forEach items="${goods.goodsImgList}" var="img">
                    <img src="images/${img.imgBig}" width="360" height="360" />
                </c:forEach>
            </div><!--buyimgBig/-->
            <ul class="buyimgsmall">
                <c:forEach items="${goods.goodsImgList}" var="img">
                    <li><img src="images/${img.imgSmall}" width="50" height="50" /></li>
                </c:forEach>
            </ul><!--buyimgsmall/-->
        </div><!--buyDtlLeft/-->
        <div class="buyDtlRight">
            <h3>${goods.goodsName}</h3>
            <h4>${goods.goodsIntr}</h4>
            <h5>价格：<span>￥</span><strong id="price_item_1"><fmt:formatNumber value="${goods.goodsPrice}" pattern=".00"/></strong></h5>
            <table class="buyTable">
                <tr>
                    <th width="70">商品编号</th>
                    <td>${goods.goodsId}</td>
                </tr>
                <tr>
                    <th width="70">运费</th>
                    <td>包邮</td>
                </tr>
                <tr>
                    <th width="70">机身颜色</th>
                    <td>
                        <ul class="buyji" id="colorUL">
                            <c:forEach items="${goods.colorList}" var="color">
                                <li colorId="${color.colorId}">${color.colorName}</li>
                            </c:forEach>
                            <div class="clears"></div>
                        </ul><!--buyji/-->
                    </td>
                </tr>
                <tr>
                    <th width="70">机身内存</th>
                    <td>
                        <ul class="buyji" id="memoryUL">
                            <c:forEach items="${goods.memoryList}" var="memory">
                                <li memoryId="${memory.memoryId}">${memory.memoryName}</li>
                            </c:forEach>
                            <div class="clears"></div>
                        </ul><!--buyji/-->
                    </td>
                </tr>
                <tr>
                    <th width="70">手机库存</th>
                    <td id="goodsNumTd">${goods.goodsNum}</td>
                </tr>
                <tr>
                    <th width="70">购买数量</th>
                    <td><form name="addItemForm" id="addItemForm"
                              action="${pageContext.request.contextPath}/cart/additem" method="post">
                        <input type="hidden" name="userId" value="${sessionScope.user.userId}"/>
                        <input type="hidden" name="gdId" value="" id="gdId"/>
                        <div class="p_number">
                            <div class="f_l add_chose">
                                <a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">-</a>
                                <input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
                                <a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">+</a>
                            </div>

                            <div class="f_l buy">
                                总价：<span class="total-font" id="total_item_1">￥89.00</span>
                                <input type="hidden" name="total_price" id="total_price" value="" />
                            </div>
                        </div>
                    </form>
                    </td>
                </tr>
            </table><!--buyTable/-->
            <div class="goumai">
                <a href="car.html" class="buy-gou">立即购买</a>
                <a href="javascript:void(0)" id="addItemA" class="buy-mai">加入购物车</a>
            </div><!--goumai/-->
        </div><!--buyDtlRight/-->
        <div class="clears"></div>
    </div><!--buyDtl/-->
    <div class="buyDtl2">
        <ul class="buydel2Eq">
            <li>商品描述</li>
            <li>规格参数</li>
            <li>包装信息</li>
            <li>售后服务</li>
            <div class="clears"></div>
        </ul><!--buydel2Eq/-->
        <div class="buydlList">
            ${goods.goodsDesc}
        </div><!--buydlList/-->
        <div class="buydlList">
            ${goods.goodsSpec}
        </div><!--buydlList/-->
        <div class="buydlList">
            ${goods.goodsPack}
        </div><!--buydlList/-->
        <div class="buydlList">
            ${goods.goodsServ}
        </div><!--buydlList/-->
    </div><!--buyDtl2/-->
</div><!--buyinfo/-->
<div class="footBox">
    <div class="footers">
        <div class="footersLeft">
            <a href="index.html"><img src="images/ftlogo.jpg" width="240" height="64" /></a>
            <h3 class="ftphone">400 000 0000 </h3>
            <div class="ftKe">
                客服 7x24小时(全年无休)<br />
                <span>客服邮箱：kefu@webqin.net </span>
            </div><!--ftKe/-->
        </div><!--footersLeft/-->
        <div class="footersRight">
            <ul>
                <li class="ftTitle">新手指南</li>
                <li><a href="#">购物流程</a></li>
                <li><a href="#">会员计划及划分</a></li>
                <li><a href="#">优惠券规则</a></li>
                <li><a href="#">联系客服</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li class="ftTitle">付款方式</li>
                <li><a href="#">在线支付</a></li>
                <li><a href="#">礼品卡支付</a></li>
                <li><a href="#">货到付款</a></li>
                <li><a href="#">银行付款</a></li>
            </ul>
            <ul>
                <li class="ftTitle">配送服务</li>
                <li><a href="#">配送时效及运费</a></li>
                <li><a href="#">超时赔付</a></li>
                <li><a href="#">验货与签收</a></li>
                <li><a href="#">配货信息跟踪</a></li>
            </ul>
            <ul>
                <li class="ftTitle">售后服务</li>
                <li><a href="#">退换货政策</a></li>
                <li><a href="#">退换货区域</a></li>
                <li><a href="#">退款时限</a></li>
                <li><a href="#">先行赔付</a></li>
                <li><a href="#">发票说明</a></li>
            </ul>
            <ul>
                <li class="ftTitle">特色服务</li>
                <li><a href="#">礼品卡</a></li>
                <li><a href="#">产品试用</a></li>
                <li><a href="#">花粉中心</a></li>
                <li><a href="#">快速购物</a></li>
                <li><a href="#">推荐好友</a></li>
            </ul>

            <div class="clears"></div>
        </div><!--footersRight/-->
        <div class="clears"></div>
    </div><!--footers/-->
</div><!--footBox/-->
<div class="footer" style="text-align:left;">
    <a href="#">关于我们</a>
    <a href="#">友情链接</a>
    <a href="#">版权声明</a>
    <a href="#">网站地图</a>
    <br />
    <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
</div><!--footer/-->
</body>
</html>
