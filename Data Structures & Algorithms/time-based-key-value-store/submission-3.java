class TimeMap {
    Map<String, Map<Integer, List<String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
        }
        if (!map.get(key).containsKey(timestamp)) {
            map.get(key).put(timestamp, new ArrayList<>());
        }
        map.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        int seen = Integer.MIN_VALUE;
        for (int time : map.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }
        if (seen == Integer.MIN_VALUE) return "";
        // if (seen == 0) return "0";

        int back = map.get(key).get(seen).size() - 1;
        return map.get(key).get(seen).get(back);
    }
}
