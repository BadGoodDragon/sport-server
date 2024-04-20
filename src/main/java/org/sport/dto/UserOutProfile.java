package org.sport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserOutProfile {
    private String username;
    private String photo;
    private Double longtitude;
    private Double latitude;
}
