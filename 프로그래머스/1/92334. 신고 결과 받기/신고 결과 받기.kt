class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val idMap = id_list.associateWith{ 0 }.toMutableMap()
        
        val reportList = report.map{it.split(" ")}
        val reportMap = reportList.groupBy({ it[1] }, { it[0] })
            .mapValues { it.value.toSet() }
            
        id_list.map{ name ->
            if(reportMap[name]!=null)
                if(reportMap[name]!!.size >= k) {
                   for(mail in reportMap[name]!!){
                        idMap[mail] = idMap[mail]!! + 1
                    }
                }
            }
        
        return idMap.values.toIntArray()
    }
}