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

       remark = "���㹻�Ĵ��"; isChinese();
       remark = "�깺ʧ��,���ϵ�����[1000051]"; isChinese();
       remark = "[51]�����㣬�뻻������"; isChinese();
       remark = "FAA:֧��ʧ��"; isChinese();
       remark = "�鷢����"; isChinese();
       remark = "�����˻�����"; isChinese();
       remark = "[61]����ȡ��ת�˽�����ƣ���ϵ������"; isChinese();
       remark = "����"; isChinese();
       remark = ""; isChinese();
       remark = "����ʧ��"; isChinese();
       remark = "�ѷ�������״̬"; isChinese();
       remark = "�깺ʧ��,�������п��ݲ�֧�ָ�ҵ�������������л�95516��ѯ[1000040]"; isChinese();
       remark = "[68]�޷�������ʱ���ڻ�ý���Ӧ�����Ժ�����"; isChinese();
       remark = "999999--����֧��ʧ��,���з��ش���:R1000:����ʧ��:����"; isChinese();
       remark = "[KJ]����ʧ��"; isChinese();
       remark = "��Ϣ����"; isChinese();
       remark = "51--[51]�����㣬�뻻������"; isChinese();
       remark = "[03]��Ч�̻�"; isChinese();
       remark = "�깺ʧ��,����"; isChinese();
       remark = "[I9]���н����У������Խ���"; isChinese();
       remark = "���׽��������޶�"; isChinese();
       remark = "�����˻�������"; isChinese();
       remark = "�ʴ�����21-24��Ϊ����ʱ����ͣ����"; isChinese();
       remark = "�깺ʧ��,�Ƶ�����������Ȩת���޶"; isChinese();
       remark = "����ȡ��������"; isChinese();
       remark = "�깺ʧ��,��������"; isChinese();
       remark = "��Ч����"; isChinese();
       remark = "����֧��ʧ��,���з��ش���:R1000:����ʧ��:����"; isChinese();
       remark = "51--����"; isChinese();
       remark = "999999--�̻��ݲ�֧�ִ˽���"; isChinese();
       remark = "��Ʒ��Ϣ������"; isChinese();
       remark = "61--[61]����ȡ��ת�˽�����ƣ���ϵ������"; isChinese();
       remark = "���г�ʱ���뷢����״̬��ѯ"; isChinese();
       remark = "[L8]BIN.�Ҳ���·��"; isChinese();
       remark = "�깺ʧ��,null"; isChinese();
       remark = "���׽���"; isChinese();
       remark = "�깺ʧ��,�ֿ��������Ϣ���ֻ������벻��ȷ����֤ʧ��[1000005]"; isChinese();
       remark = "����֧��ʧ��,���з��ش���:R6000:���׽�������;�޶�"; isChinese();
       remark = "[OG]���ʻ����޶�����ޣ�����ϵ��Ǯ"; isChinese();
       remark = "�깺ʧ��,�����н���Ȩ�����ޣ���������ѯ���ķ�����[1000061]"; isChinese();
       remark = "�깺ʧ��,����ϵͳ��æ"; isChinese();
       remark = "�̻��ݲ�֧�ִ˽���"; isChinese();
       remark = "�����޶�Ӧ�ۿ��¼"; isChinese();
       remark = "δ֪���д�����Ϣ"; isChinese();
       remark = "��������޶�"; isChinese();
       remark = "�깺ʧ��,���п�δ��ͨ��֤֧��[1000057]"; isChinese();
       remark = "[W6]�ֻ��š����֤���롢�����뿪��ʱ�ǼǵĲ�һ��"; isChinese();
       remark = "[92]������ͨ��������ϣ����Ժ�����"; isChinese();
       remark = "�깺ʧ��,���������������[1000075]"; isChinese();
       remark = "[14]��Ч���ţ��޴˺ţ����뻻������"; isChinese();
       remark = "�깺ʧ��,����ʧ�ܣ���������ѯ���ķ�����[1000041]"; isChinese();
       remark = "�깺ʧ��,�ͻ���Ϣδ�Ǽǣ���ǩԼ�򿪻�"; isChinese();
       remark = "[96]ϵͳ�쳣��ʧЧ������ϵ��Ǯ"; isChinese();
       remark = "ϵͳ����"; isChinese();
       remark = "[I3]���ṩ��ȷ��֤�����룬�������������ÿ�ʱ��֤������һ��"; isChinese();
       remark = "����������"; isChinese();
       remark = "�̻��Ѿ����˺�����"; isChinese();
       remark = "��ʧ��־����ȷ"; isChinese();
       remark = "���ν��׳����̻����ս������!"; isChinese();
       remark = "�ڻ���˾�ʽ��˻��������˻�δ������Ӧ��ϵ"; isChinese();
       remark = "ϵͳ�쳣"; isChinese();
       remark = "���׽���С��100Ԫ"; isChinese();
       remark = "[LG]�����п�δ��ͨ��������֧��ҵ��"; isChinese();
       remark = "[HZ]֤���Ų���"; isChinese();
       remark = "��·�ɻ������ر�"; isChinese();
       remark = "[I5]�����ֿ������õĽ����޶��ֿ�����ϵ�������е����޶�"; isChinese();
       remark = "�鿪����ԭ��"; isChinese();
       remark = "[02]����ϵ��Ǯ��˾"; isChinese();
       remark = "�����쳣������ϵ����"; isChinese();
       remark = "31--��·�ɻ������ر�"; isChinese();
       remark = "�깺ʱ��������Ҫ��ֵ�������׽������"; isChinese();
       remark = "�깺ʧ��,����У���������"; isChinese();
       remark = "֤������"; isChinese();
       remark = "�������ݼ�����ߴ����"; isChinese();
       remark = "[K8]��������У���"; isChinese();
       remark = "14--��Ч����"; isChinese();
       remark = "[68]deal time out"; isChinese();
       remark = "01--�鿪����ԭ��"; isChinese();
       remark = "[MM]�̻������������ô���"; isChinese();
       remark = "��������ϵͳ����[ϵͳ�������ڲ���ȷ]"; isChinese();
       remark = "[05]����ж�"; isChinese();
       remark = "�깺ʧ��,�����������������������ʧ�ܣ����Ժ�����"; isChinese();
       remark = "�깺ʧ��,����ʧ�ܣ���������ѯ���ķ�����[1000091]"; isChinese();
       remark = "����ϵͳ���󣬽���״̬δ֪"; isChinese();
       remark = "[90]�������մ���ϵͳ��ֹһ��Ļ����ʼ�ڶ���Ļ�������ڼ����Ӻ���ٴη��ͣ�"; isChinese();
       remark = "[12]��Ч���ף�����ϵ��Ǯ"; isChinese();
       remark = "[76]��Ч�˻�"; isChinese();
       remark = "999999--����֧��ʧ��,���з��ش���:R2000:����ʧ��:�˻�״̬��"; isChinese();
       remark = "ֱ�������޶�"; isChinese();
       remark = "[41]��ʧ��"; isChinese();
       remark = "�깺ʧ��,�˻�״̬����ȷ"; isChinese();
       remark = "���п������������"; isChinese();
       remark = "�깺ʧ��,�����Ʒ�������"; isChinese();
       remark = "[94]�ظ�����"; isChinese();
       remark = "�깺ʱ��������Ҫ��ֵ�����û��󶨵����п���Ҫ����ǩԼ"; isChinese();
       remark = "�û�ֱ��״̬�쳣"; isChinese();
       remark = "����˾���׽���ʽ����,���׽��Ȳ�Ϊ12λ"; isChinese();
       remark = "[T3]һ�����в��ܰ󶨶��ſ�����δ��"; isChinese();
       remark = "�깺ʧ��,��������[2020023]"; isChinese();
       remark = "[42]�޴��˻�"; isChinese();
       remark = "�깺ʧ��,��ȡ��ֵ���ʧ��"; isChinese();
       remark = "FAA"; isChinese();
       remark = "[75]�������������ޣ��뻻������"; isChinese();
       remark = "[AA]����ȷ�Ĺ���̨"; isChinese();
       remark = "�깺ʧ��,��ʧ��־����ȷ"; isChinese();
       remark = "���м�����п�����"; isChinese();
       remark = "�깺ʱ��������Ҫ��ֵ�������׽��ó���500,000Ԫ"; isChinese();
       remark = "����δ���ÿ�������"; isChinese();
       remark = "���������޶�"; isChinese();
       remark = "�ѹ�ʧ��"; isChinese();
       remark = "[error_code:YH000011] ϵͳ���ڽ������ս��㣬���Ժ����ԣ�"; isChinese();
       remark = "�깺ʧ��,û���ҵ���Ӧ�ĳɹ�ǩԼ��¼(PayId)"; isChinese();
       remark = "68--[68]�޷�������ʱ���ڻ�ý���Ӧ�����Ժ�����"; isChinese();
       remark = "��״̬������"; isChinese();
       remark = "���÷��񷵻�ʧ��:SA0100001"; isChinese();
       remark = "�깺ʧ��,���׽���[2020003]"; isChinese();
       remark = "cann't find CommandHandler with bank code:s10"; isChinese();
       remark = "������֤���Ų���"; isChinese();
       remark = "�깺ʧ��,����ʧ�ܡ���������ѯ95516[1000036]"; isChinese();
       remark = "û�иñʽ��Ѽ�¼"; isChinese();
       remark = "[CD]��״̬�쳣����֤���Ų���"; isChinese();
       remark = "[B0]�ֿ��˳����󶨴���"; isChinese();
       remark = "[JA]ԭ�ֻ��ŵİ󶨹�ϵ������"; isChinese();
       remark = "[B.MGW.0170]No transaction[externalRefNumber='201504180002021315', refNumber='null'] exists!"; isChinese();
                        remark = "[B.MGW.0170]No transaction[externalRefNumber='2015042402076343', refNumber='null'] exists!"; isChinese();
       remark = "94--�ظ�ҵ��,������:2015052102343941"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504170002020966', refNumber='null'] exists!"; isChinese();
       remark = "cann't find CommandHandler with bank code:s07"; isChinese();
       remark = "���������޶�"; isChinese();
       remark = "���ڲ�Ϊ��3��,�޷���������"; isChinese();
       remark = "[A4]��Ȩ.�Ҳ�����Ȩ�ն�"; isChinese();
       remark = "û�в鵽������ˮ��Ϣ����ȷ���Ƿ��Ѿ��ύ������"; isChinese();
       remark = "[55]�����������������"; isChinese();
       remark = "�깺ʧ��,���ӷ�����ʧ��(12152)������ñʽ���Ϊ�����ף���������ȷ�������Ⱥ˶���ϸ����"; isChinese();
       remark = "�깺ʧ��,��������"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504180002021322', refNumber='null'] exists!"; isChinese();
       remark = "���м���˻��쳣"; isChinese();
       remark = "�깺ʧ��,����ʧ�ܡ���������ѯ95516[2700002]"; isChinese();
        remark = "[B.MGW.0170]No transaction[externalRefNumber='201504200002038370', refNumber='null'] exists!"; isChinese();
       remark = "�ظ�ҵ��,������:2015051802303892"; isChinese();
       remark = "[65]����ȡ��/���Ѵ�������"; isChinese();
       remark = "���������еĻ�Աû��Ϊ�����п���ͨ�˻�"; isChinese();
       remark = "0:֧��ʧ��"; isChinese();
       remark = "FCR-����:�����Բ�����˽��� 73:���п���ͷ��ʧ:6230582819820306666"; isChinese();
       remark = "�����ѱ�������110385500"; isChinese();

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

    // �������ж����ĺ��ֺͷ���
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
            remark = "����Ľ���ʧ���ˡ�";
        System.out.println(remark + "\n");
        return pos;
    }

}
