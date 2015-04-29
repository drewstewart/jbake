title=ManageSPInventory
version=1.1.15
date=2015-20-04
type=interface-specification
status=published
~~~~~~

# Document Control

This document represents a view of the service model from Rational Software Architect. This specification is intended bo read-only and any changes must be made within the service model.

**Title** - Interface Functional Specification: ManageSPInventory

## Revision History

| Version | Date       | Details                                           |
|---------|------------|---------------------------------------------------|
| V0.1    | 2014/08/24 | First draft based on EPS ICD 1.0 |
| V0.2    | 2014/09/08 | Updates based on review feedback for first draft. |
| V0.3    | 2014/09/24 | Candidate for IR12 base-lining. Updates based on review feedback for 2nd draft, including removal of most 'TBD' comments. Spec and samples are assumed to agreed 'as-is'. |
| V0.4    | 2014/10/28 | Initial IR13 changes based on EPS ICD v1.3. <ul><li>Categorised valid resource types for Satellite and Wireless.</li><li>Sample data for oduAntennaSize (either 80cm, 120cm or 180cm), oduTrialType (either 3W or 6W)</li></ul> |
| V0.3 | 201/5.4.13k| etc etc |

{% include "../introduction.md" %}

# Service Description

This service provides operations which allow Fulfilment to retrieve inventory details from the platform. This includes:

- Querying for network inventory
- Querying for resource inventory

**Notes about using this service**:

- The <accessSeekerId> attribute of the CIM header used in requests / responses and notifications should be set to the value of the B2B __party Id__ of the Service Delivery Partner. It is not used in this service to represent an Access Seeker who has previously submitted an order to NBN Co.




## Information Model

![Information Model][information_model]


# Sample Messages

## getNetworkInventory

**Query network inventory fails - ID not found**

 - This is a sample request message for the scenario: Query network inventory fails because the id cannot be found. [Exception - ID Not Found](./samples/getNetworkInventory/Exception_ID_Not_Found/00_getNetworkInventoryRequest.xml)
 - This is a sample response message for the scenario: Query network inventory fails because the id cannot be found. [Exception - ID Not Found](./samples/getNetworkInventory/Exception_ID_Not_Found/00_getNetworkInventoryRequest.xml)

# Appendix A

[information_model]: /img/information_model.png
