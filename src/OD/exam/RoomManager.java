package OD.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description：
 * @Date：2024-06-22
 * @Author：landaguo
 */
public class RoomManager {

    /**
     * 请设计一个租房信息管理系统，完成核心类RoomManager，需要实现如下方法。
     * 	public boolean addRoom(int id, int area, int price, int rooms)：在系统中增加一套编号为 id，面积为 area，月租金为 price，卧室数量为 rooms的房源：
     * 1）若系统中不存在编号为 id的房源，则添加该房源，返回 true；
     * 2）若已存在，则将对应房源信息更新为新传入的 area、price、rooms，并返回 false；
     * 3）租金不得高于参考价格，超过无法添加或更新，返回false。
     * 参考价格： 面积（0,50]：3000 ； 面积(50,100]: 6000；面积100以上：10000
     * 	public boolean deleteRoom(int id)：删除系统中编号为 id 的房源：
     * 若存在编号为 id 的房源，删除此房源并返回 true；若不存在，返回 false。
     * 	public int[] queryRoom(int area, int price, int rooms)：查询符合筛选条件的房源id。返回结果按照价格升序排列。
     * Ø  筛选条件：面积大于等于 area，月租金小于等于 price，卧室数为 rooms 的房源；
     *
     * @param args
     */
    public static void main(String[] args) {
        addRoom(1,25,3000,3);
        addRoom(2,75,6000,4);
        addRoom(3,125,10000,5);

        System.out.println(111);
    }

    private static List<Room> roomList= new ArrayList<>();

    public static boolean addRoom(int id, int area, int price, int rooms){
        if (area > 0 && area <= 50 && price > 3000) return false;
        if (area > 50 && area <= 100 && price > 6000) return false;
        if (area > 100 && price > 10000) return false;
        // 若已存在，则将对应房源信息更新为新传入的 area、price、rooms，并返回 false；
        boolean findExistFlag = queryRoomById(id, area, price, rooms);
        if (!findExistFlag) return false;
        Room room = new Room(id, area, price, rooms);
        roomList.add(room);
        return true;
    }

    public boolean deleteRoom(int id){
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                roomList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 筛选条件：面积大于等于 area，月租金小于等于 price，卧室数为 rooms 的房源；
     * @param area
     * @param price
     * @param rooms
     * @return
     */
    public static int[] queryRoom(int area, int price, int rooms){
        List<Room> result = roomList.stream().filter(v -> {
            return v.getArea() >= area && v.getPrice() <= price && v.getRooms() == rooms;
        }).sorted((a, b) -> {
            return a.getPrice() - b.price;
        }).collect(Collectors.toList());
        int[] roomArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            roomArr[i] = result.get(i).getId();
        }
        return roomArr;
    }

    public static boolean queryRoomById(int id, int area, int price, int rooms){
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                roomList.get(i).setArea(area);
                roomList.get(i).setPrice(price);
                roomList.get(i).setRooms(rooms);
                return false;
            }
        }
        return true;
    }

    static class Room{
        Room(int id, int area, int price, int rooms){
            this.id = id;
            this.area = area;
            this.price  = price;
            this.rooms = rooms;
        }

        private int id;

        private int area;

        private int price;

        private int rooms;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getRooms() {
            return rooms;
        }

        public void setRooms(int rooms) {
            this.rooms = rooms;
        }
    }


}
