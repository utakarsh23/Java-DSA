package LeetCode;

class StringCompression {
    public int compress(char[] chars) {
        // Map<Character, Integer> map = new HashMap<>();
        // for(char c : chars) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }

        // int x = 0;
        // for(char c : map.keySet()) {
        //     if(map.get(c) == 1) {
        //         x++;
        //     } else if(map.get(c) > 1) {
        //         x+= map.get(c)+1;
        //     }
        // }
        // for(int )
        // return x;
        // int i = 0; int j = 0;
        // while(i < chars.length && j < chats.length) {
        //     while()
        // }
        if(chars.length == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        char temp = chars[0];
        for(int i = 1; i <= chars.length; i++) {
            int t = i-1;
            while(i < chars.length && chars[i] == temp) {
                i++;
            }
            if(i - t == 1) {
                sb.append(temp);
            } else {
                sb.append(temp);
                sb.append(i - t);
            }
            temp = i < chars.length ? chars[i] : chars[chars.length-1];
        }

        int i = 0;
        for(i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return i;
    }
}