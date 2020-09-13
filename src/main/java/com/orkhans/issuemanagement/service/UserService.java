package com.orkhans.issuemanagement.service;

import com.orkhans.issuemanagement.dto.UserDto;
import com.orkhans.issuemanagement.entity.IssueHistory;
import com.orkhans.issuemanagement.entity.User;
import com.orkhans.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);

}
