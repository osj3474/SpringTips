package me.sangjin.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter   // getter가 있어야 반환 시점에 serialize가능
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
}
