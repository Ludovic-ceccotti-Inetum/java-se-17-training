package io.spring.training.boot.chapter7;

import java.util.Date;

public class Tractor {
    private String name;
    private String engine;
    private double cost;
    private Date builddate;

    private Tractor() {}

    @Override
    public String toString() {
        return "Tractor{" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", cost=" + cost +
                ", builddate=" + builddate +
                '}';
    }

    public static class Builder {
        private Tractor instance = new Tractor();

        Builder() {}

        public Builder name(String name) {
            this.instance.name = name;
            return this;
        }

        public Builder engine(String engine) {
            this.instance.engine = engine;
            return this;
        }

        public Builder cost(double cost) {
            this.instance.cost = cost;
            return this;
        }

        public Builder builddate(Date builddate) {
            this.instance.builddate = builddate;
            return this;
        }

        public Tractor build() {
            Tractor builtTractor = this.instance;
            this.instance = null; //avoid modification
            return builtTractor;
        }
    }
}
