# Huddersfield Lost and Found Tracker

A menu-driven Java console application for reporting, searching and resolving lost-item records in a bus station scenario.

## Project background

Created by **Prakash Bahadur G C** for **XFX1063: Software Design & Development**, International Study Centre, University of Huddersfield. Original portfolio submitted on **14 June 2025**.

## Features

- Register a lost item with its name, location and report timestamp.
- Display active reports from newest to oldest.
- Search records using a case-insensitive keyword.
- Mark an item as found and remove its active record.
- Reject empty item names and duplicate names, ignoring case.
- Use a repeating menu with an exit option.

## Collections used

| Collection | Role |
| --- | --- |
| `ArrayList<String>` | Stores records for keyword searches. |
| `HashMap<String, String>` | Maps an item name to its record for removal. |
| `HashSet<String>` | Tracks registered names and rejects duplicates. |
| `Stack<String>` | Stores report entries, displayed in reverse order. |

## Skills demonstrated

Java collections, console input with `Scanner`, methods, loops, switch statements, string processing and basic record management.

## Run locally

Install a Java Development Kit (JDK 8 or newer). From the repository root:

```bash
mkdir -p build
javac -encoding UTF-8 -d build src/HuddersfieldLostFoundTracker.java
java -cp build HuddersfieldLostFoundTracker
```

On Windows, create the `build` folder in File Explorer or use `mkdir build`, then run the same Java commands.

## Example interaction

```text
1. Report lost item
2. View all items
3. Search items
4. Mark item as found
5. Exit
Your choice: 1

Enter item name: Wallet
Enter location lost or last seen: Waiting area

Item registered successfully!
```

## Changes since the original portfolio

- Corrected the newest-first display order.
- Rejected duplicate and empty item names to keep the collections consistent.
- Clarified the location prompt for reporting a lost item.

## Limitations and future improvements

Records are stored in memory and disappear when the program exits. Only one active item per name is supported; different people cannot report separate items with the same name. Keyword searches match the whole stored entry, including location and timestamp. This is an independent coursework demonstration, not an official bus station service; the contact number retained from the original code has not been verified as current.

Possible improvements include unique report IDs, a dedicated item class, file or database storage, stronger input validation, end-of-input handling and automated tests.
