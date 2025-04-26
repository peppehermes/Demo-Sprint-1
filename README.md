## Postal Office Queue Manager

Demo project for Software Engineering II.

### Definition of Done

- Unit tests (passing)
- E2E (End-to-End) acceptance test given by the customer
- Code on VCS (Version Control System)
- Code review

### System configuration

Implement a postal office management tool to handle requests from customers.
Counters are the available workers at the postal office.

Default: 3 counters

Requests: Packages and accounts

Counters: One counter for packages, one for account, the other for both.

Ticket: letter for service (P for Packages, A for Accounts), three digits number, logo, date & hour.

Max dim for a queue: 8 hours open, 30 person served per hour, times the number of counters.

Restart counter from 0 every time you restart the system (e.g. every day).
