import java.util.HashMap;
import java.util.HashSet;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/10-20:02
 */
public class AirplanSeatRsvp {
    public int solution(int N, String occupied) {
        HashMap<Integer, HashSet<Character>> map = new HashMap<>();
        if(occupied != null && occupied.length() != 0) {
            String[] occupiedArr = occupied.split(" ");
            for (int i = 0; i < occupiedArr.length; i++) {
                int key = Integer.valueOf(occupiedArr[i].substring(0, 1));
                char val = occupiedArr[i].charAt(1);
                map.putIfAbsent(key, new HashSet<>());
                map.get(key).add(val);
            }
        }

        int res = (N-map.size()) * 2;
        for(Integer key : map.keySet()) {
            HashSet<Character> set = map.get(key);
            boolean left = true, right = true, middle = true;

            if(set.contains('D') || set.contains('E')) left = middle = false;
            if(set.contains('F') || set.contains('G')) right = middle = false;
            if(set.contains('B') || set.contains('C')) left = false;
            if(set.contains('H') || set.contains('I')) right = false;

            if (left && middle && right) res += 2;
            else if(left || middle || right) res += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        AirplanSeatRsvp airplanSeatRsvp = new AirplanSeatRsvp();
        System.out.println(airplanSeatRsvp.solution(2, "1A 2F 1C")); // 2
        System.out.println(airplanSeatRsvp.solution(1, "")); // 2
    }
}
