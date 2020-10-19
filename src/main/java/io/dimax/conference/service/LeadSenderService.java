package io.dimax.conference.service;

import io.dimax.conference.model.User;

public interface LeadSenderService {
     void send(User user);
}