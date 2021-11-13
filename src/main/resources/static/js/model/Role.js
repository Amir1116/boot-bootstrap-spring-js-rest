class Role{
    constructor(id, role, authority) {
        this.id = id;
        this.role = role;
        this.authority = authority;
    }
   static createRole(role) {
        switch (role) {
            case "ADMIN":
                return new Role(1, "ADMIN", "ADMIN");
            case "USER":
                return new Role(2, "USER", "USER");
        }
    }

    toJSON(){
        return {
            "id":this.id,
            "role": this.role,
            "authority": this.authority,
        }
    }
}

