-- liquibase formatted sql

-- changeset salikhdev:1769436853999-1
ALTER TABLE group_students
    ADD created_at TIMESTAMP;

-- changeset salikhdev:1769436853999-2
ALTER TABLE group_students
    ALTER COLUMN created_at SET NOT NULL;
