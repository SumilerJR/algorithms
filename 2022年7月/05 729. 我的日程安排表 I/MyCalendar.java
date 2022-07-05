class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i=0;i<list.size();i++){
            int a[]=list.get(i);
            if(!(end-1<a[0]||start>a[1])){return false;}
        }
        list.add(new int[]{start,end-1});
        return true;
    }
}
