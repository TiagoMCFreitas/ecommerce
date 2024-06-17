package com.ecommerce.service;

import com.ecommerce.model.Session;
import com.ecommerce.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session saveSession(Session session) {
            return sessionRepository.save(session);
    }

    public Session getSessionByIdUser(long id) {
        return sessionRepository.findByUsuario(id);
    }

    public Session getUserByIdSession(String uuid) {
        return sessionRepository.getUserByIdSession(uuid);
    }
}
