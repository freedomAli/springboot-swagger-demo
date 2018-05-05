package com.zhan.swagger.controllers;

import com.zhan.swagger.entity.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanyanjun on 2018/5/4.
 */
@RestController
@RequestMapping("/user")
@Api(description = "swagger demo controller")
public class SwaggerDemoController {

    @ApiOperation(value = "通过用户id获取用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@ApiParam(value = "用户ID") @RequestParam("userId") String userId) {
        User user = new User();
        user.setId(1);
        user.setName("zhanyanjun");
        user.setAge(20);
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.PUT)
    @ApiImplicitParam(name = "user", value = "用户信息",required = true, dataType = "User")
    @ApiResponses(@ApiResponse(code = 409, message = "用户已存在"))
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
