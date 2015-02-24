package net.devops.demo.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "models")
public class Model {

    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private Long socialNumber;

    public Model() {
    }

    public Model(String id, String firstName, String secondName, String lastName, Long socialNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.socialNumber = socialNumber;
    }

    public static ModelBuilder builder() {
        return new ModelBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getSocialNumber() {
        return this.socialNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialNumber(Long socialNumber) {
        this.socialNumber = socialNumber;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Model)) return false;
        final Model other = (Model) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstName = this.firstName;
        final Object other$firstName = other.firstName;
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$secondName = this.secondName;
        final Object other$secondName = other.secondName;
        if (this$secondName == null ? other$secondName != null : !this$secondName.equals(other$secondName)) return false;
        final Object this$lastName = this.lastName;
        final Object other$lastName = other.lastName;
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$socialNumber = this.socialNumber;
        final Object other$socialNumber = other.socialNumber;
        if (this$socialNumber == null ? other$socialNumber != null : !this$socialNumber.equals(other$socialNumber)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        final Object $firstName = this.firstName;
        result = result * PRIME + ($firstName == null ? 0 : $firstName.hashCode());
        final Object $secondName = this.secondName;
        result = result * PRIME + ($secondName == null ? 0 : $secondName.hashCode());
        final Object $lastName = this.lastName;
        result = result * PRIME + ($lastName == null ? 0 : $lastName.hashCode());
        final Object $socialNumber = this.socialNumber;
        result = result * PRIME + ($socialNumber == null ? 0 : $socialNumber.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Model;
    }

    public String toString() {
        return "net.devops.demo.mongo.Model(id=" + this.id + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", lastName=" + this.lastName + ", socialNumber=" + this.socialNumber + ")";
    }

    public static class ModelBuilder {
        private String id;
        private String firstName;
        private String secondName;
        private String lastName;
        private Long socialNumber;

        ModelBuilder() {
        }

        public Model.ModelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public Model.ModelBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Model.ModelBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Model.ModelBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Model.ModelBuilder socialNumber(Long socialNumber) {
            this.socialNumber = socialNumber;
            return this;
        }

        public Model build() {
            return new Model(id, firstName, secondName, lastName, socialNumber);
        }

        public String toString() {
            return "net.devops.demo.mongo.Model.ModelBuilder(id=" + this.id + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", lastName=" + this.lastName + ", socialNumber=" + this.socialNumber + ")";
        }
    }
}
