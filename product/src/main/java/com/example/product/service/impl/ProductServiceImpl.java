package com.example.product.service.impl;

import com.example.product.dto.CartDTO;
import com.example.product.entity.ProductInfo;
import com.example.product.enums.ProductStatusEnum;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * ProductServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:54
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public List<ProductInfo> findAllOnSell() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByProductIdIn(List<Integer> productListId) {

        return productInfoRepository.findByProductIdIn(productListId);
    }

    //事务操作
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartdto : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartdto.getProductId());
            ProductInfo productInfo = productInfoOptional.get();
            //库存足够才允许购买(减库存)
            if (productInfo.getProductStock() >= cartdto.getProductQuantity()) {
                productInfo.setProductStock(productInfo.getProductStock() - cartdto.getProductQuantity());
                productInfoRepository.save(productInfo);
            }
        }
    }

}
