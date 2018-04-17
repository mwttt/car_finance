package com.jk.finance.mongo.impl;

import com.jk.finance.entity.FictitiousUser;
import com.jk.finance.entity.LoginUser;
import com.jk.finance.mongo.MongoDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.L;

@Repository
public class MongoDaoImpl implements MongoDao {

        @Resource
        private MongoTemplate  mongoTemplate;

        @Override
        public Map<String, Map<String, Map<String, Integer>>> queryMapByCookId(String cookieValue) {

                Query query = new Query(Criteria.where("cookieId").is(cookieValue));
                List<FictitiousUser> fictitiousUser = mongoTemplate.find(query, FictitiousUser.class, "fictitiousUser");
                if (fictitiousUser.size() > 0) {

                        return fictitiousUser.get(0).getGoodsMap();
                }

                return null;
        }

        @Override
        public void updateMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date) {

            Query query = new Query(Criteria.where("cookieId").is(cookieValue));
            mongoTemplate.updateFirst(query, new Update().set("goodsMap", maps).set("cookTime", date), FictitiousUser.class, "fictitiousUser");
        }

        @Override
        public void addMap(Map<String, Map<String, Map<String, Integer>>> maps, String cookieValue, Date date) {

                FictitiousUser  fictitiousUser = new FictitiousUser();
                fictitiousUser.setCookId(cookieValue);
                fictitiousUser.setGoodsMap(maps);
                fictitiousUser.setCookTime(date);
                mongoTemplate.insert(fictitiousUser, "fictitiousUser" );
        }

        @Override // 查询登录账户的库存
        public LoginUser queryDB(String registerId) {
            Query query = new Query(Criteria.where("registerId").is(registerId));
            List<LoginUser> loginUser = mongoTemplate.find(query, LoginUser.class, "loginUser");
            if (loginUser.size() > 0) {

                return  loginUser.get(0);
            }

            return null;
        }

        @Override // 添加新的registerId
        public void addFirstBuyerCart(String registerId, Map<String, Map<String, Map<String, Integer>>> map) {

                LoginUser loginUser = new LoginUser();
                loginUser.setRegisterId(registerId);
                loginUser.setGoodsMap(map);
                mongoTemplate.insert(loginUser, "loginUser");
        }

        @Override // 根据修改registerId 修改 大字段
        public void updateLoginMap2(String registerId, Map<String ,Map<String, Map<String, Integer>>> loginMap) {

            System.out.println("mondao---"+loginMap);
            Query query = new Query(Criteria.where("registerId").is(registerId));
            mongoTemplate.updateFirst(query, new Update().set("goodsMap", loginMap), LoginUser.class, "loginUser");
        }

    @Override
    public void deleteBuyerCartByCookieId(String cookieValue) {

        Query  query = new Query(Criteria.where("cookieId").is(cookieValue));
        mongoTemplate.remove(query, "fictitiousUser");
    }
}