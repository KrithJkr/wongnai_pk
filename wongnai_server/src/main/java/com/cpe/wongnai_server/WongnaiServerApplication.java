package com.cpe.wongnai_server;
import java.util.stream.Stream;
import com.cpe.wongnai_server.*;
import com.cpe.wongnai_server.Repository.CategoriesRepository;
import com.cpe.wongnai_server.Repository.CookingRepository;
import com.cpe.wongnai_server.Repository.MeatRepository;
import com.cpe.wongnai_server.Repository.MemberRepository;
import com.cpe.wongnai_server.Repository.MenuRepository;
import com.cpe.wongnai_server.entity.Categories;
import com.cpe.wongnai_server.entity.Cooking;
import com.cpe.wongnai_server.entity.Meat;
import com.cpe.wongnai_server.entity.Member;
import com.cpe.wongnai_server.entity.Menu;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class WongnaiServerApplication {
public static void main(String[] args) {
		SpringApplication.run(WongnaiServerApplication.class, args);
	}
    @Bean
    ApplicationRunner init(CategoriesRepository categoriesRepository,MeatRepository meatRepository,CookingRepository cookingRepository,
    MemberRepository memberRepository,MenuRepository menuRepository) {
        return args ->{
            Stream.of("Clean Food", "Normal Food", "Fast Food", "Fine Dinning").forEach(catName -> {
                Categories cat = new Categories();
                cat.setCatName(catName);
               categoriesRepository.save(cat);
            });
            categoriesRepository.findAll().forEach(System.out::println);
            Stream.of("Fish", "Pork", "Chicken", "Beef").forEach(meatName -> {
              Meat  meat = new Meat();
              meat.setMeatName(meatName);
              meatRepository.save(meat);
          });
            meatRepository.findAll().forEach(System.out::println);
            Stream.of("Pheekay", "Threerapat", "Anan", "Thotsaphon").forEach(memberName -> {
              Member member = new Member();
              member.setMemberName(memberName);
              memberRepository.save(member);
          });
         memberRepository.findAll().forEach(System.out::println);
         Stream.of("พักปลาสดไว้ในอุณหภูมิห้องราว 1 ชั่วโมง ให้น้ำในตัวปลาระเหยออกแล้วโรยเกลือลงบนตัวปลาทั้ง 2 ด้านอุ่นกระทะสแตนเลสให้บนเตาให้ร้อนจัด ใส่น้ำมัน 1 ช้อนโต๊ะ และเกลือ 1 หยิบมือลงไปคั่วจนน้ำมันร้อนเป็นไอ ค่อยเทน้ำมันออกและเช็ดผิวกระทะด้วยผ้าสะอาด กระทะจะลื่นไม่ติดหนังปลาเทน้ำมันลงกระทะอีกครั้ง รอจนน้ำมันเดือด ค่อยใส่ปลาลงไปทอดด้วยไฟปานกลาง หากต้องการให้ปลากรอบมาก ต้องใส่น้ำมันเยอะท่วมตัวปลาอย่าพลิกปลาบ่อยๆ  รอให้สุกทีละด้านค่อยพลิก ปลาทอดจะสวยงามไม่ขาดแยกชิ้นพักปลาบนกระดาษซับน้ำมันสักครู่ก่อนเสิร์ฟร้อนๆ พร้อมซอสและเครื่องเคียงตามใจชอบ"
         ).forEach(cookingName -> {
         Cooking cooking = new Cooking();
         cooking.setCookingName(cookingName);
         cookingRepository.save(cooking);

         });
       cookingRepository.findAll().forEach(System.out::println);
      Menu menu = new Menu();
       menu.setMenuName("ปลาทอด");
       menu.setPicUrl("https://image.ibb.co/czMyLf/image.jpg");
       menu.setMeatId(meatRepository.getOne(1L));
       menu.setCatId(categoriesRepository.getOne(2L));
       menu.setMemberId(memberRepository.getOne(1L));
       menu.setCookingId(cookingRepository.getOne(1L));
       menuRepository.save(menu);
        };
      }
}








