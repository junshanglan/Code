package OD.T_2025.A.one.模拟;

import java.util.*;

public class 异常的打卡记录 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Record> recordList = new ArrayList<>();
        List<String> sourceRecord = new ArrayList<>();
        Map<Integer,List<Record>> recordMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            sourceRecord.add(tmp);
            Record record = splitStr(tmp,i);
            recordMap.computeIfAbsent(record.id, k ->new ArrayList<Record>()).add(record);
            recordList.add(record);
        }
        Set<Integer> result = new  TreeSet<>();
        for (int i = 0; i < recordList.size(); i++) {
            Record tmp = recordList.get(i);
            if (!tmp.actualDeviceNumber.equals(tmp.registeredDeviceNumber)) {
                result.add(i);
            }
            for (Record record : recordMap.get(recordList.get(i).id)) {
                if (isAbnormal(tmp,record)){
                    result.add(i);
                    result.add(record.idx);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("null");
        }else{
            for (Integer idx : result) {
                System.out.print(sourceRecord.get(idx) + ";");
            }
        }


    }

    private static boolean isAbnormal(Record record1,Record record2){
        // 两个打卡记录时间小于 60分钟，并且打卡距离超过 5km
        if (record1.time < 60 && record2.time < 60 && Math.abs(record1.distance - record2.distance) > 5){
            return true;
        }
        return false;
    }

    private static Record splitStr(String s,int idx){
        String[] split = s.split(",");
        int id = Integer.parseInt(split[0]);
        int time = Integer.parseInt(split[1]);
        int distance = Integer.parseInt(split[2]);
        String actualDeviceNumber = split[3];
        String registeredDeviceNumber = split[4];
        return new Record(id,time,distance,actualDeviceNumber,registeredDeviceNumber,idx);
    }
}

class Record{
    int id;
    int time;
    int distance;
    String actualDeviceNumber;
    String registeredDeviceNumber;
    int idx;

    Record(int id,int time,int distance,String actualDeviceNumber,String registeredDeviceNumber,int idx){
        this.id = id;
        this.time = time;
        this.distance = distance;
        this.actualDeviceNumber = actualDeviceNumber;
        this.registeredDeviceNumber = registeredDeviceNumber;
        this.idx = idx;
    }
}
