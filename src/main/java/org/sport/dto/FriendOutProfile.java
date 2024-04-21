package org.sport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FriendOutProfile {
    private String username;
    private String photo;
    private Double longtitude;
    private Double latitude;
}
