package com.company.permission.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author candylove
 * @date 2024/12/3 11:04
 */
@Data
@Schema(description = "分页请求对象")
public class PageParamRequest {

    @Schema(description = "页码")
    private int page;

    @Schema(description = "每页数量")
    private int limit;

}
