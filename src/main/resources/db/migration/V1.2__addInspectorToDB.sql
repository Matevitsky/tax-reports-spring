WITH inserted AS (
    INSERT INTO employee
        (first_name, last_name, email, password)
        VALUES ('inspector', 'inspector', 'inspector@test.tes',
                '$2a$10$M6tV.VclMbK.VTPIlglUS.I6pjidQrZACEYedPb.csMrOSYwc.rjO')
        RETURNING user_id
)
INSERT
INTO user_roles (user_id, role)
SELECT inserted.user_id, 'INSPECTOR'
FROM inserted;
