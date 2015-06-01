package com.beyeasy.hellogit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beyeasy.hellogit.pojo.ManagerPO;
import com.beyeasy.hellogit.pojo.UserPO;
import com.beyeasy.hellogit.pojo.base.BasePO;

public class HelloGitTest {

    private String MyGit = "MyGit";

    private String HelloGit = "HelloGit";
    
    private static String remark;

    public static void main(String[] args) {

        BasePO base = new BasePO();
        base.setFirstname("liu");
        base.setSecondname("tao");
        base.setAddress("shenzhen");
        base.setMobile("15566803060");
        base.setQq("122512");
        base.setWx("DangDangDaddy");
        System.out.println(base.toString());

        UserPO upo = new UserPO(base);
        System.out.println(upo.toString());

        ManagerPO mpo = new ManagerPO(base);
        System.out.println(mpo.toString());

        System.out.println(base.toString());

        String msg = "[000]MyTest";

        if (msg.startsWith("[")) {
            int pos = msg.indexOf("]");
            if (pos > 0)
                msg = msg.substring(pos + 1);
        }
        System.out.println(msg);

        // boolean isemail = isEmail("liut@jjmmw.com");
        // isemail = isEmail("liut@jjmmw");
        // isemail = isEmail("jjmmw.com");
        // isemail = isEmail("liut#jjmmw.com");

       remark = "无足够的存款"; isChinese();
       remark = "申购失败,卡上的余额不足[1000051]"; isChinese();
       remark = "[51]卡余额不足，请换卡交易"; isChinese();
       remark = "FAA:支付失败"; isChinese();
       remark = "查发卡方"; isChinese();
       remark = "银行账户余额不足"; isChinese();
       remark = "[61]超出取款转账金额限制，联系发卡行"; isChinese();
       remark = "余额不足"; isChinese();
       remark = ""; isChinese();
       remark = "交易失败"; isChinese();
       remark = "已发送银行状态"; isChinese();
       remark = "申购失败,您的银行卡暂不支持该业务，请向您的银行或95516咨询[1000040]"; isChinese();
       remark = "[68]无法在正常时间内获得交易应答，请稍后重试"; isChinese();
       remark = "999999--银行支付失败,银行返回错误:R1000:交易失败:余额不足"; isChinese();
       remark = "[KJ]交易失败"; isChinese();
       remark = "信息不符"; isChinese();
       remark = "51--[51]卡余额不足，请换卡交易"; isChinese();
       remark = "[03]无效商户"; isChinese();
       remark = "申购失败,余额不足"; isChinese();
       remark = "[I9]银行结帐中，请重试交易"; isChinese();
       remark = "交易金额超过渠道限额"; isChinese();
       remark = "银行账户不存在"; isChinese();
       remark = "邮储银行21-24点为清算时间暂停交易"; isChinese();
       remark = "申购失败,制单金额超出单笔授权转账限额。"; isChinese();
       remark = "超出取款金额限制"; isChinese();
       remark = "申购失败,金额超出限制"; isChinese();
       remark = "无效卡号"; isChinese();
       remark = "银行支付失败,银行返回错误:R1000:交易失败:余额不足"; isChinese();
       remark = "51--余额不足"; isChinese();
       remark = "999999--商户暂不支持此交易"; isChinese();
       remark = "产品信息不存在"; isChinese();
       remark = "61--[61]超出取款转账金额限制，联系发卡行"; isChinese();
       remark = "银行超时，请发起交易状态查询"; isChinese();
       remark = "[L8]BIN.找不到路由"; isChinese();
       remark = "申购失败,null"; isChinese();
       remark = "交易金额超限"; isChinese();
       remark = "申购失败,持卡人身份信息或手机号输入不正确，验证失败[1000005]"; isChinese();
       remark = "银行支付失败,银行返回错误:R6000:交易金额大于用途限额"; isChinese();
       remark = "[OG]单笔或日限额超过上限，请联系快钱"; isChinese();
       remark = "申购失败,发卡行交易权限受限，详情请咨询您的发卡行[1000061]"; isChinese();
       remark = "申购失败,银行系统繁忙"; isChinese();
       remark = "商户暂不支持此交易"; isChinese();
       remark = "银行无对应扣款记录"; isChinese();
       remark = "未知银行错误信息"; isChinese();
       remark = "超出提款限额"; isChinese();
       remark = "申购失败,银行卡未开通认证支付[1000057]"; isChinese();
       remark = "[W6]手机号、身份证号码、姓名与开户时登记的不一致"; isChinese();
       remark = "[92]与银行通信网络故障，请稍后重试"; isChinese();
       remark = "申购失败,密码输入次数超限[1000075]"; isChinese();
       remark = "[14]无效卡号（无此号），请换卡重试"; isChinese();
       remark = "申购失败,交易失败，详情请咨询您的发卡行[1000041]"; isChinese();
       remark = "申购失败,客户信息未登记，请签约或开户"; isChinese();
       remark = "[96]系统异常、失效，请联系快钱"; isChinese();
       remark = "系统错误"; isChinese();
       remark = "[I3]请提供正确的证件号码，必须与申请信用卡时的证件号码一致"; isChinese();
       remark = "单笔最大金额超限"; isChinese();
       remark = "商户已经过了合作期"; isChinese();
       remark = "挂失标志不正确"; isChinese();
       remark = "本次交易超出商户单日金额限制!"; isChinese();
       remark = "期货公司资金账户与银行账户未建立对应关系"; isChinese();
       remark = "系统异常"; isChinese();
       remark = "交易金额不能小于100元"; isChinese();
       remark = "[LG]该银行卡未开通银联在线支付业务"; isChinese();
       remark = "[HZ]证件号不符"; isChinese();
       remark = "无路由或渠道关闭"; isChinese();
       remark = "[I5]超出持卡人设置的交易限额，请持卡人联系发卡银行调高限额"; isChinese();
       remark = "查开户方原因"; isChinese();
       remark = "[02]请联系快钱公司"; isChinese();
       remark = "银行异常，请联系银行"; isChinese();
       remark = "31--无路由或渠道关闭"; isChinese();
       remark = "申购时因余额不足需要充值，而交易金额有误"; isChinese();
       remark = "申购失败,密码校验次数超限"; isChinese();
       remark = "证件不符"; isChinese();
       remark = "报文内容检查错或者处理错"; isChinese();
       remark = "[K8]基础参数校验错"; isChinese();
       remark = "14--无效卡号"; isChinese();
       remark = "[68]deal time out"; isChinese();
       remark = "01--查开户方原因"; isChinese();
       remark = "[MM]商户清算中心配置错误"; isChinese();
       remark = "银行主机系统错误[系统工作日期不正确]"; isChinese();
       remark = "[05]不予承兑"; isChinese();
       remark = "申购失败,监控中心正在重启或者启动失败，请稍后再试"; isChinese();
       remark = "申购失败,交易失败，详情请咨询您的发卡行[1000091]"; isChinese();
       remark = "银行系统错误，交易状态未知"; isChinese();
       remark = "[90]正在日终处理（系统终止一天的活动，开始第二天的活动，交易在几分钟后可再次发送）"; isChinese();
       remark = "[12]无效交易，请联系快钱"; isChinese();
       remark = "[76]无效账户"; isChinese();
       remark = "999999--银行支付失败,银行返回错误:R2000:交易失败:账户状态错"; isChinese();
       remark = "直付金额超出限额"; isChinese();
       remark = "[41]挂失卡"; isChinese();
       remark = "申购失败,账户状态不正确"; isChinese();
       remark = "银行卡关联问题出错"; isChinese();
       remark = "申购失败,基金产品代码错误"; isChinese();
       remark = "[94]重复交易"; isChinese();
       remark = "申购时因余额不足需要充值，而用户绑定的银行卡需要重新签约"; isChinese();
       remark = "用户直付状态异常"; isChinese();
       remark = "基金公司交易金额格式错误,交易金额长度不为12位"; isChinese();
       remark = "[T3]一个银行不能绑定多张卡或者未绑定"; isChinese();
       remark = "申购失败,风险受限[2020023]"; isChinese();
       remark = "[42]无此账户"; isChinese();
       remark = "申购失败,获取充值结果失败"; isChinese();
       remark = "FAA"; isChinese();
       remark = "[75]密码错误次数超限，请换卡重试"; isChinese();
       remark = "[AA]不正确的工作台"; isChinese();
       remark = "申购失败,挂失标志不正确"; isChinese();
       remark = "银行检查银行卡错误"; isChinese();
       remark = "申购时因余额不足需要充值，而交易金额不得超过500,000元"; isChinese();
       remark = "机构未配置可用渠道"; isChinese();
       remark = "超出交易限额"; isChinese();
       remark = "已挂失折"; isChinese();
       remark = "[error_code:YH000011] 系统正在进行日终结算，请稍后再试！"; isChinese();
       remark = "申购失败,没有找到对应的成功签约记录(PayId)"; isChinese();
       remark = "68--[68]无法在正常时间内获得交易应答，请稍后重试"; isChinese();
       remark = "卡状态不正常"; isChinese();
       remark = "调用服务返回失败:SA0100001"; isChinese();
       remark = "申购失败,交易金额超限[2020003]"; isChinese();
       remark = "cann't find CommandHandler with bank code:s10"; isChinese();
       remark = "户名或证件号不符"; isChinese();
       remark = "申购失败,交易失败。详情请咨询95516[1000036]"; isChinese();
       remark = "没有该笔交费记录"; isChinese();
       remark = "[CD]卡状态异常或户名证件号不符"; isChinese();
       remark = "[B0]持卡人撤销绑定错误"; isChinese();
       remark = "[JA]原手机号的绑定关系不存在"; isChinese();
       remark = "[B.MGW.0170]No transaction[externalRefNumber='201504180002021315', refNumber='null'] exists!"; isChinese();
                        remark = "[B.MGW.0170]No transaction[externalRefNumber='2015042402076343', refNumber='null'] exists!"; isChinese();
       remark = "94--重复业务,订单号:2015052102343941"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504170002020966', refNumber='null'] exists!"; isChinese();
       remark = "cann't find CommandHandler with bank code:s07"; isChinese();
       remark = "超出单笔限额"; isChinese();
       remark = "日期不为近3天,无法继续交易"; isChinese();
       remark = "[A4]授权.找不到授权终端"; isChinese();
       remark = "没有查到交易流水信息，请确认是否已经提交到银行"; isChinese();
       remark = "[55]密码错误，请重新输入"; isChinese();
       remark = "申购失败,连接服务器失败(12152)（如果该笔交易为帐务交易，则处理结果不确定，请先核对明细！）"; isChinese();
       remark = "申购失败,卡已销户"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504180002021322', refNumber='null'] exists!"; isChinese();
       remark = "银行检查账户异常"; isChinese();
       remark = "申购失败,交易失败。详情请咨询95516[2700002]"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504200002038370', refNumber='null'] exists!"; isChinese();
       remark = "重复业务,订单号:2015051802303892"; isChinese();
       remark = "[65]超出取款/消费次数限制"; isChinese();
       remark = "交易请求中的会员没有为该银行卡开通账户"; isChinese();
       remark = "0:支付失败"; isChinese();
       remark = "FCR-返回:卡属性不允许此交易 73:银行卡口头挂失:6230582819820306666"; isChinese();
       remark = "机构已被撤并：110385500"; isChinese();

    }

    private static boolean isEmail(String email) {
        Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    // 完整的判断中文汉字和符号
    public static int isChinese() {
        remark = remark.trim();
        System.out.println(remark);
        char[] ch = remark.toCharArray();
        int pos = -1;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                pos = i;
                break;
            }
        }
        
        if (pos >= 0){
            remark = remark.substring(pos);

        }else 
            remark = "他妈的交易失败了。";
        System.out.println(remark + "\n");
        return pos;
    }

}
