WITH inserted AS (
    INSERT INTO employee
        (first_name, last_name, email, password)
        VALUES ('admin', 'admin', 'admin@test.tes', '$2a$10$Qp28lHO65aB90A8GU262ROawNiwSjaKWS6CevoHUEqe0mtVQ8yDia')
        RETURNING user_id
)

INSERT
INTO user_roles (user_id, role)
SELECT inserted.user_id, 'ADMIN'
FROM inserted;
