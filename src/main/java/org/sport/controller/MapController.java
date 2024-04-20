package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.service.ProfileService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapController {
    private final ProfileService profileService;
}
