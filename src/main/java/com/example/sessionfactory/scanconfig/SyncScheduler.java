package com.example.sessionfactory.scanconfig;

import com.example.sessionfactory.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncScheduler {

    @Autowired
    private SyncService syncService;

   // @Scheduled(fixedRate = 3000)  // Run every 3 seconds
   @Scheduled(cron = "0 * * * * ?")
    public void syncDatabases(){
        syncService.syncFromDb1ToDb2();
        syncService.syncDeletions();
    }
}
