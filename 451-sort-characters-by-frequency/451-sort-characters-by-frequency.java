class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer>map=new TreeMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((obj1,obj2)->obj2.frequency-obj1.frequency);
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sbil=new StringBuilder();
        while(!pq.isEmpty()){
            Pair obj=pq.poll();
            char c=obj.ch;
            int f=obj.frequency;
            for(int i=0;i<f;i++){
                sbil.append(c+"");
            }
        }
        return sbil.toString();
    }
    class Pair{
        int frequency;
        char ch;
        public Pair(char ch,int frequency){
            this.ch=ch;
            this.frequency=frequency;
        }
    }
}
