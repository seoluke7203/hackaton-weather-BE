package asac06.hackathon.weather;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ProductCategoryForInit {
    T01("A1", "반팔", "상의"),
    T02("A1", "민소매", "상의"),
    T04("A1", "린넨옷", "상의"),
    T03("A2", "얇은셔츠", "상의"),
    T05("A2", "긴팔티", "상의"),
    T06("A2", "니트", "상의"),
    T07("A2", "후드", "상의"),
    T08("A3", "맨투맨", "상의"),
    T09("A3", "니트", "상의"),
    T10("A4", "히트텍", "상의"),
    T11("A4", "기모맨투맨", "상의"),

    B01("B1", "반바지", "하의"),
    B02("B1", "얇은바지", "하의"),
    B03("B2", "면바지", "하의"),
    B04("B2", "슬렉스", "하의"),
    B05("B2", "청바지", "하의"),
    B06("B3", "긴바지", "하의"),
    B07("B3", "청바지", "하의"),
    B08("B4", "기모바지", "하의"),

    O01("C3", "가디건", "외투"),
    O02("C3", "점퍼", "외투"),
    O03("C3", "야상", "외투"),
    O04("C4", "가죽자켓", "외투"),
    O05("C4", "코트", "외투"),
    O06("C4", "롱패딩", "외투"),
    O07("C4", "울코트", "외투");

    private final String recommendCode;
    private final String categoryDetail;
    private final String category;
}
