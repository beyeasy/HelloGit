package com.beyeasy.hellogit;

import com.beyeasy.hellogit.pojo.ManagerPO;
import com.beyeasy.hellogit.pojo.UserPO;
import com.beyeasy.hellogit.pojo.base.BasePO;

public class HelloGitTest {

    private String MyGit = "MyGit";

    private String HelloGit = "HelloGit";

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

    }

}
