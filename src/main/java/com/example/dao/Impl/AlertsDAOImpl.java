package com.example.dao.Impl;

import com.example.dao.AlertsDAO;
import com.example.dto.Alerts;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.MorphiaIterator;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ishaan
 */
@Repository
public class AlertsDAOImpl implements AlertsDAO {

    @Autowired
    Datastore datastore;

    public void create(Alerts alerts) {
        datastore.save(alerts);
    }

    public List<Alerts> getAlerts() {
        final Query<Alerts> query = datastore.createQuery(Alerts.class);

        final List<Alerts> listOfAlerts = query.asList();
        return listOfAlerts;
    }

    @Override
    public List<Alerts> getAlerts(Date from, Date to) {
        final MorphiaIterator<Alerts, Alerts> morphiaIterator = datastore.createQuery(Alerts.class).field("creationDate").lessThan(to).field("creationDate").greaterThan((from)).fetch();
        List<Alerts> alertsList=new ArrayList<>();
        Iterator<Alerts> alertsIterator = morphiaIterator.iterator();
        while(alertsIterator.hasNext()){
            Alerts alert = alertsIterator.next();
            alertsList.add(alert);
        }
        return alertsList;
    }
}
