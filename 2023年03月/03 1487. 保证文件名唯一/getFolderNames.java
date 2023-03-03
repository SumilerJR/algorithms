//挺有意思，一开始没想到压缩优化，超时了，简单改一下就行
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        // Queue<String> res = new LinkedList<String>();
        for (int i = 0; i < res.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {//无
                map.put(name, 1);
                res[i] = name;
            } else {//已有
                int k = map.get(name);//从已有文件名获取后缀
                while (map.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                    //直到没有该文件名
                    map.put(name + "(" + k + ")", 1);//添加未来同名文件的后缀
                    map.put(name, k + 1);//修改未来同名文件的后缀
                    res[i] = name + "(" + k + ")";
            }
        }
        return res;
    }
}