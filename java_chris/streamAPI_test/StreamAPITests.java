package streamAPI_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITests {

    public static class Role {
        private String roleName;

        public Role(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }

    public static void main(String[] args) {
        // Stream creations
        String[] arr = new String[]{"a", "b", "c", "d"};
        Stream<String> arrStream1 = Arrays.stream(arr);
        Stream<String> arrStream2 = Stream.of(arr);

//        Stream<String> stream = list.stream();

        // anyMatch
        Role admin = new Role("admin");
        Role user = new Role("user");
        Role vip = new Role("vip");
        List<Role> roleList = new ArrayList<>();
        roleList.add(admin);
        roleList.add(user);
        roleList.add(vip);

        boolean isSubscribed = roleList.stream().anyMatch(r -> r.getRoleName().equals("vip"));
        System.out.println(isSubscribed);
    }
}


