module live.kavinduj.theserenitymhtc {
    requires javafx.controls;
    requires javafx.fxml;
    requires bcrypt;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires java.sql;

    exports live.kavinduj.theserenitymhtc;
    exports live.kavinduj.theserenitymhtc.controller to javafx.fxml;
    opens live.kavinduj.theserenitymhtc to javafx.fxml;
    exports live.kavinduj.theserenitymhtc.bo;
    exports live.kavinduj.theserenitymhtc.dao.custom.impl;
    exports live.kavinduj.theserenitymhtc.entity;
    opens live.kavinduj.theserenitymhtc.bo to javafx.fxml;
    opens live.kavinduj.theserenitymhtc.entity to org.hibernate.orm.core;
    opens live.kavinduj.theserenitymhtc.controller to javafx.fxml;
}