package io.datajek.springapop.movierecommenderaop.busines;

import io.datajek.springapop.movierecommenderaop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique2 {
    @Autowired
    private User user;

    public String collaborativeFiltering() {
        return user.getUserDetails();
    }
}
