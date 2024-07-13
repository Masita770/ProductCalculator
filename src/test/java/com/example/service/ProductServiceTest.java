package com.example.service;

import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import com.example.mapper.ProductMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {



    @Mock
    ProductMapper mapper;

    @InjectMocks
    ProductService service;



//    @Test
//    void 全件検索() {
//        ProductService sut = new ProductService(mapper);
//        List<Products> expected = new ArrayList<>();
//        List<Products> actual = sut.getAll();
//        assertEquals(expected, actual);
//        List<Products> u = service.getAll();
//        when(mapper.selectAll()).thenReturn(List.of(createProducts()));
//                assertEquals(1, .size());
//                verify(mapper).selectAll();

//        ProductService sut = new ProductService(mapper);
//        List<Products> expected = new ArrayList<>();
//        List<Products> setExpected = new ArrayList<>();
//    }

//    @Test
//    void 全て検索() {
//        Products products();
//        when(mapper.selectAll())
//    }
//
//    private Products createProducts() {
//        Products products = new Products();
//        products.setId(1);
//        products.setProduct("机");
//        return products;
//    }


    @Test
    void 全件検索 () {
        List<Products> products = List.of(
                new Products(1, "1", "オフィスデスク", "机", "50000")
        );
        when(mapper.selectAll()).thenReturn(products);
        List<Products> actual = service.getAll();
        assertThat(actual).isEqualTo(products);
        verify(mapper).selectAll();
//        when(mapper.selectAll()).thenReturn(List.of(
//                new Products(1, "1", "オフィスデスク", "机", "50000"))
//        );
//        verify(mapper.selectAll());
//        List<Products> actual = new ArrayList<>();
//        assertTrue(actual.add(new Products(1, "1", "オフィスデスク", "机", "50000")));
//        when(mapper.selectAll()).thenReturn(createProducts());
//                assertEquals(1, createProducts());
//                verify(mapper).selectAll();
//                new Products(),
//                new Products(),
//                new Products()
//        ));
//        List<Products> products = service.getAll();
//                assertEquals(3, products.size());
//        List.of(new Products(1, "Nagano", "33024"),
//                new Products(2, "nakazima", "34287"),
//                new Products(3, "Yamashita", "55435"));
//        verify(mapper).selectAll();
//        Products products = createProducts();
//        when(mapper.selectAll())
//        when(mapper.selectAll()).thenReturn(createOrdinaryProducts());
//        assertTrue(service.getAll());
    }


    private Products createProducts() {
        Products products = new Products();
//        List<Products> products = new ArrayList<>() {{get(1), get(2), get(3)}};
        products.setProduct("オフィスデスク");
        products.setPNumber("1");
        products.setCategory("机");
        products.setPrice("50000");
        return products;
    }

    private List<Products> createOrdinaryProducts() {
        List<Products> products = new ArrayList<>();
//        new Products()
//        Products products1 = new Products();
//        products1.setProduct("ビジネスデスク");
//        products1.setCategory("机");
//        products1.setPrice("800");
        return products;
    }


        // 実行
//        List<Products> actual = sut.getAll();
//
//        // 検証
//        assertEquals(expected, actual);

        // 後処理
        // DBに変更を加えた場合ここで戻す
//    }
}