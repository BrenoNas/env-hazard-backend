CREATE TABLE hazard_media (
    id UUID PRIMARY KEY,
    hazard_id UUID NOT NULL,
    media_id UUID NOT NULL,
    FOREIGN KEY (hazard_id) REFERENCES hazard(id),
    FOREIGN KEY (media_id) REFERENCES media(id)
);
