CREATE TABLE IF NOT EXISTS Socio(
    id TEXT PRIMARY KEY NOT NULL,
    nombre TEXT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
)